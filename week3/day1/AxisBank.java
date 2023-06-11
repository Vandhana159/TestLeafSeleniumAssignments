package testLeafAssignments.week3.day1;

public class AxisBank extends BankInfo{
	public void deposit()
	{
		System.out.println("Deposit limit : 50,000/day");
	}


	public static void main(String[] args) {
		AxisBank abObj = new AxisBank();
		abObj.saving();
		abObj.fixed();
		abObj.deposit();
	}

}
