package pair;

public class NewUser {
	private String name;
	private String password;

	public NewUser (String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() { return name; }
	public String getPassword() { return password; }
}
