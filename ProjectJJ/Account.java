public class Account
{

private String accountName;
private String accountPassword;
private String accountEmail;

public Account(String accountName, String accountPassword, String accountEmail)
{
	super();
	this.accountName = accountName;
	this.accountPassword = accountPassword;
	this.accountEmail = accountEmail;
}

@Override
public String toString()
{
	return "Account Name: " + accountName + "\nAccount Email: " + accountEmail + "\n Account Password :" + accountPassword;
}
}