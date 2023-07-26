package OopJavaHW06.work3;
public class Greeter {

	public String greet(Formality formality) {
		return switch (formality) {
			case formal -> "Good evening, sir.";
			case casual -> "Sup bro?";
			case intimate -> "Hello Darling!";
			default -> "Hello.";
		};
	}

	public void setFormality(Formality formality) {
	}
}