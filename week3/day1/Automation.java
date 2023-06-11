package testLeafAssignments.week3.day1;

public class Automation extends MultipleLangauge implements Language,TestTool{
public static void main(String[] args) {
	Automation autoObj = new Automation();
	autoObj.Selenium();
	autoObj.Java();
	autoObj.python();
	autoObj.ruby();
}

public void Selenium() {
	System.out.println("Selenium IDE was originally developed by Jason Huggins when"
			+ " he worked at ThoughtWorks in Chicago in 2004 ");
}

public void Java() {
	System.out.println("\n\nJava was originally developed by James Gosling at Sun Microsystems. "
			+ "\nIt was released in May 1995 as a core component of Sun Microsystems' Java platform.");
}

public void ruby() {
	System.out.println("\n\nRuby is an object-oriented and interpreted programming language created by"
			+ " Yukihiro Matsumoto in 1993. ");
}
}
