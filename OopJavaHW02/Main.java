package OopJavaHW02;


import java.security.SecureRandom;

public class Main {
	public static void main(String[] args) {

		SecureRandom rand = new SecureRandom();
		Render render = new Render();

		Building building1 = new Building(100);
		building1.setCurrentHealth(rand.nextInt(50));
		render.showIndicator(building1);

		Hero hero1 = new Hero(150, 100);
		hero1.setCurrentHealth(rand.nextInt(151));
		hero1.setCurrentMana(rand.nextInt(101));
		render.showIndicator(hero1);

	}

	static class Render {

		/**
		 * Если объект обладает уровнем здоровья,
		 * то отображается индикатор с текущим уровнем здоровья.
		 * Если объект обладает уровнем магический энергии,
		 * то отображается индикатор с текущим уровнем энергии.
		 */
		public void showIndicator(Substance substance) {
			System.out.println("\u001B[0m" + substance.getClass().toString().substring(
					substance.getClass().toString().indexOf(".") + 1) + " id: " +
					substance.getId());
			if (substance instanceof HasHealth) {
				int max = ((HasHealth) substance).getMaxHealth();
				int curr = ((HasHealth) substance).getCurrentHealth();
				System.out.printf("\u001B[0m" + "Max Current Health: %s / %s ", max, curr);
				grapfIndicator(max, curr);

			}
			if (substance instanceof HasMana) {
				int max = ((HasMana) substance).getMaxMana();
				int curr = ((HasMana) substance).getCurrentMana();
				System.out.printf("\u001B[0m" + "Max Current Health Mana: %s / %s ", max, curr);
				grapfIndicator(max, curr);
			}
		}

		public void grapfIndicator(int max, int curr) {

			final String ANSI_RESET = "\u001B[0m";
			final String ANSI_RED = "\u001B[31m";
			final String ANSI_GREEN = "\u001B[32m";
			final String ANSI_YELLOW = "\u001B[33m";


			String changeColor;
			if (max == 0) {
				changeColor = ANSI_RESET;
			}
			int amount = 10 * curr / max;

			changeColor = switch (amount) {
				case 0, 1, 2, 3 -> ANSI_RED;
				case 4, 5, 6 -> ANSI_YELLOW;
				default -> ANSI_GREEN;
			};
			System.out.print(changeColor + "[");
			for (int i = 0; i < amount; i++) {
				System.out.print(changeColor + "+");
			}
			for (int i = amount; i < max / 10; i++) {
				System.out.print(" ");
			}
			System.out.print(changeColor + "]");
			System.out.println(ANSI_RESET + " ");

		}

	}


}