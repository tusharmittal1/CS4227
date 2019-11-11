public class accountBuilder{

private String accountName;
private String accountPassword;
private String accountEmail;

public accountBuilder setAccountName(String accountName){
this.accountName = accountName;
return this;
}

public accountBuilder setAccountPassword(String accountPassword){
this.accountPassword = accountPassword;
return this;
}

public accountBuilder setAccountEmail(String accountEmail){
this.accountEmail = accountEmail;
return this;
}

public Account getAccount()
{
return new Account(accountName, accountPassword, accountEmail);
}
}