package org.system;

public class Desktop extends Computer{
	public void desktopSize() {
		System.out.println("Desktop Size : 18 inches");
	}
	public static void main(String[] args) {
		Desktop deskObject = new Desktop();
		deskObject.computerModel();
		deskObject.desktopSize();
	}
}
