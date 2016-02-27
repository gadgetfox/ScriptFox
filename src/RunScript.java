import java.io.*;
public class RunScript {{
	//this class will contain the methods to run scripts
	
	//method to run shell scripts, in environment that supports shell.
	try {
		String target = new String("/home/hagrawal/test.sh");
        // String target = new String("mkdir stackOver");
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(target);
        proc.waitFor();
        StringBuffer output = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";                       
        while ((line = reader.readLine())!= null) {
          output.append(line + "\n");
        }
        System.out.println("### " + output);
        } catch (Throwable t) {
             t.printStackTrace();
        }
	
	
}}