//Method 2: Using Appium.js with Node.exe (opening GUI version of Appium using code) or Using Apache Comman Exec API .

package serverAutoLaunch;

//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.*;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class AppiumServerCmd {
	//static String NodePath="C:\\Progra~1\\Appium\\node.exe";
	static String NodePath="C:/Progra~1/nodejs/node.exe";
	
	
	//static String AppiumJS_path="C:\\Progra~1\\Appium\\node_modules\\appium\\bin\\appium.js";
	static String AppiumJS_path="C:/Users/Ashish Rawat/AppData/Local/Programs/appium-desktop/resources/app/node_modules/appium/build/lib/main.js";
	
	static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


	//@BeforeTest

	public void startServer() throws InterruptedException,ExecuteException,IOException
	{

		CommandLine command=new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument(NodePath);
		command.addArgument(AppiumJS_path);
		command.addArgument("--address",false);
		command.addArgument("0.0.0.0");//127.0.0.1
		command.addArgument("--port",false);
		command.addArgument("4723"); //4724
		command.addArgument("--full-reset",false);
	//	command.addArgument("--log-level",false); //true if want logs



		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor=new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command,resultHandler);

		System.out.println("..................Starting the Appium Server..............."+"\n"+df.format(new Date())+
				"\n=================================================================================");
		Thread.sleep(30000);


	}


	//@AfterTest

	public void stopServer() throws InterruptedException,ExecuteException,IOException
	{


		CommandLine command=new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("Taskkill /F /IM node.exe");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor=new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command,resultHandler);

		System.out.println("\n===================================================================================="+"\n....................Stopping the Appium Server................"+"\n"+df.format(new Date()));

	}

	
	
	
}
