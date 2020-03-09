package ex.resource.exp.artificial.controller.n5sparsehide;

import com.p6spy.engine.spy.P6SpyDriver;
import org.evomaster.client.java.controller.ExternalSutController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.api.dto.SutInfoDto;
import org.evomaster.client.java.controller.db.DbCleaner;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;
import org.h2.tools.Server;
import org.hibernate.dialect.H2Dialect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.autogenerated.rest.artificial.cs.n5sparsehide.*;
/** automatically created on 2020-01-14 */
public class ExternalEvoMasterController extends ExternalSutController {
  public ExternalEvoMasterController() {
    this(40100, "n5-sparse-hide/n5-sparse-hide-cs/target/n5-sparse-hide-sut.jar", 12345, 120);
  }

  public ExternalEvoMasterController(
      int controllerPort_var, String jarLocation_var, int sutPort_var, int timeoutSeconds_var) {
    this.jarLocation = jarLocation_var;
    this.sutPort = sutPort_var;
    this.timeoutSeconds = timeoutSeconds_var;
    this.dbPort = sutPort_var + 1;
    setControllerPort(controllerPort_var);
  }

  private final String jarLocation;
  private final int sutPort;
  private final int timeoutSeconds;
  private final int dbPort;
  private Connection connection;
  private Server h2;

  public static void main(String[] args) {
    int controllerPort = 40100;
    if (args.length > 0) {
      controllerPort = Integer.parseInt(args[0]);
    }
    int sutPort = 12345;
    if (args.length > 1) {
      sutPort = Integer.parseInt(args[1]);
    }
    String jarLocation = "n5-sparse-hide/n5-sparse-hide-cs/target";
    if (args.length > 2) {
      jarLocation = args[2];
    }
    if (!jarLocation.endsWith(".jar")) {
      jarLocation += "/n5-sparse-hide-sut.jar";
    }

    int timeoutSeconds = 120;
    if (args.length > 3) {
      timeoutSeconds = Integer.parseInt(args[3]);
    }

    ExternalEvoMasterController controller =
        new ExternalEvoMasterController(controllerPort, jarLocation, sutPort, timeoutSeconds);
    InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);

    starter.start();
  }

  private String dbUrl(boolean withP6Spy) {
    String url = "jdbc";
    if (withP6Spy) {
      url += ":p6spy";
    }
    url += ":h2:tcp://localhost:" + dbPort + "/./temp/tmp_n5-sparse-hide-cs/testdb_" + dbPort;

    return url;
  }

  @Override
  public String[] getInputParameters() {
    return new String[] {};
  }

  public String[] getJVMParameters() {
    return new String[] {
      "-Dserver.port=" + sutPort,
      // FIXME: re-enable once fixed issue with Spring
      "-Dspring.datasource.url=" + dbUrl(true) + ";DB_CLOSE_DELAY=-1",
      "-Dspring.datasource.driver-class-name=" + P6SpyDriver.class.getName(),
      "-Dspring.jpa.database-platform=" + H2Dialect.class.getName(),
      "-Dspring.datasource.username=sa",
      "-Dspring.datasource.password",
      "-Dspring.jpa.properties.hibernate.show_sql=true"
    };
  }

  @Override
  public String getBaseURL() {
    return "http://localhost:" + sutPort;
  }

  @Override
  public String getPathToExecutableJar() {
    return jarLocation;
  }

  @Override
  public String getLogMessageOfInitializedServer() {
    return "Started ResApp in ";
  }

  @Override
  public long getMaxAwaitForInitializationInSeconds() {
    return timeoutSeconds;
  }

  @Override
  public void preStart() {
    try {
      // starting H2
      h2 = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "" + dbPort);
      h2.start();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void postStart() {
    closeDataBaseConnection();

    try {
      Class.forName("org.h2.Driver");
      connection = DriverManager.getConnection(dbUrl(false), "sa", "");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void resetStateOfSUT() {
    DbCleaner.clearDatabase_H2(connection);
  }

  @Override
  public void preStop() {
    closeDataBaseConnection();
  }

  @Override
  public void postStop() {
    if (h2 != null) {
      h2.stop();
    }
  }

  private void closeDataBaseConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection = null;
    }
  }

  @Override
  public String getPackagePrefixesToCover() {
    return "org.autogenerated.rest.artificial.cs.n5sparsehide.";
  }

  @Override
  public ProblemInfo getProblemInfo() {
    return new RestProblem(getBaseURL() + "/v2/api-docs", null);
  }

  @Override
  public SutInfoDto.OutputFormat getPreferredOutputFormat() {
    return SutInfoDto.OutputFormat.JAVA_JUNIT_4;
  }

  @Override
  public List<AuthenticationDto> getInfoForAuthentication() {
    return null;
  }

  @Override
  public Connection getConnection() {
    return connection;
  }

  @Override
  public String getDatabaseDriverName() {
    return "org.h2.Driver";
  }
}
