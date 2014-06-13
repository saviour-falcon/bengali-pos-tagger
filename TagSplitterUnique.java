// Input Format is java FileSplitter input_file tag
import java.io.*;
import java.util.*;
class TagSplitter {
public static void main(String args[]) throws IOException {
	BufferedReader brin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));
	Writer brout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]+".txt"), "UTF-8"));
	String line;
	String tokened;
	Set<String> lines = new LinkedHashSet();
	while((line = brin.readLine())!=null) {
		
		StringTokenizer lineSplitter = new StringTokenizer(line, " ");
		while (lineSplitter.hasMoreTokens()) {
		tokened = lineSplitter.nextToken();
			tokened = tokened.replaceAll("	"," ");
			tokened = tokened.substring(tokened.indexOf(' ')+1, tokened.length());
			

			if(tokened.matches("(.*)"+args[1])) {
				lines.add(tokened.substring(0, tokened.indexOf("\\")));
				//brout.write(System.getProperty("line.separator"));
				
			}
	}
}

for (String insert : lines)
{
	brout.write(insert);
	brout.write(System.getProperty("line.separator"));
}

brout.close();
brin.close();
}
}