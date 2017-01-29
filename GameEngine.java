//okreœlanie wspó³rzêdnych na board = najpierw pionowa, potem pozioma.

package Game;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameEngine {

	public static void readDecision(Player ob1, Player ob2) {

		Integer x = 0;
		while (x == 0) {
			Scanner skaner = new Scanner(System.in);
			String decision = skaner.next();
			if (decision.matches("[1-7]")) {
				x = x.parseInt(decision);
			} else {
				System.out.println("Nieznana komenda");
				Help.helpDisplay();
			}
		}
		System.out.println("Wybrano " + x);
		switch (x) {
		case 1: {
			GameEngine.finishTour();
			break;
		}
		case 2: {
			System.out.println("Twoje statki");
			ob1.shipDistribution.displayBoard();
			break;
		}
		case 3: {
			System.out.println("Twoja plansza trafieñ");
			ob1.previousShotsDistribution.displayBoard();
			break;
		}
		case 4: {
			GameEngine.shootTheOpponent(ob1, ob2);
			break;
		}
		case 5: {
			Help.helpDisplay();
			break;
		}
		case 6: {
			System.out.println("Plansza wroga:\n");
			ob2.shipDistribution.displayBoard();
			System.out.println();
			System.out.println("Plansza trafieñ nale¿¹ca do wroga");
			ob2.previousShotsDistribution.displayBoard();
			break;
		}
		case 7: {
			System.out.println("player1 :" + ob1.getHitCounter());
			System.out.println("player2 :" + ob2.getHitCounter());
		}

		}

	}

	public static Coordinates readCoordinates() { // ok, pozioma to litera, a
													// pionowa to liczba
		boolean properInputFlag = false;
		Coordinates c = new Coordinates();

		while (!properInputFlag) {
			System.out.println("Podaj wspó³rzêdne");
			Scanner skaner = new Scanner(System.in);
			String usersInput = skaner.next();

			if (usersInput.matches("[a-j][0-9]")) {
				c.setHorizontalPosition(Coordinates.letterToNumber.get(usersInput.substring(0, 1)));
				c.setVerticalPosition(Integer.parseInt(usersInput.substring(1, 2)));
				properInputFlag = true;
			} else {
				System.out.println("Niepoprawny format, jeszcze raz");
			}
		}
		return c;
	}

	public static void finishTour() {
		Game.player1IsActive = !Game.player1IsActive;
	}

	public static void shootTheOpponent(Player ob1, Player ob2) {

		Coordinates coordinates = GameEngine.readCoordinates();
		if (ob2.shipDistribution.board[coordinates.getVerticalPosition()][coordinates.getHorizontalPosition()] == 0) {
			ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
					.getHorizontalPosition()] = 1;
		} else {
			ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
					.getHorizontalPosition()] = 2;
			ob2.shipDistribution.board[coordinates.getVerticalPosition()][coordinates.getHorizontalPosition()] = 3;
			ob1.incrementHitCounter();
			System.out.println("Trafi³eœ! :)");
		}
		ob2.shipDistribution.displayBoard();
		GameEngine.finishTour();
	}

	public static void setShips(Player ob) {
		for (Ship ship : ob.ships) {// mam wszystkie jego sttaki
			System.out.println("Liczba masztów: " + ship.masts.length);
			switch (ship.masts.length) {
			case 1: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						// jak oznaczyæ maszt ¿e jest ju¿ ustawiony.
						Coordinates coordinates = readCoordinates();
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;
							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;
			}
			case 2: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = readCoordinates();
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;
			}
			case 3: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = readCoordinates();
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;

			}
			case 4: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = readCoordinates();
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;

			}

			}
		}
		ob.shipDistribution.displayBoard();

	}

	public static void setShipsAutomatically(Player ob) {
//		for (int i = 0; i < 20; i++) {
//			int[] coordinates = new int[2];
//			coordinates[0] = (int) (10 * Math.random());
//			coordinates[1] = (int) (10 * Math.random());
//			if (ob.shipDistribution.board[coordinates[0]][coordinates[1]] == 0) {
//				ob.shipDistribution.board[coordinates[0]][coordinates[1]] = 1;
//			} else {
//				System.out.println("UPs, Tam ju¿ jest statek!:)");
//				System.out.println("Spróbujê jeszcze raz :)");
//				i--;
//			}
//		}
//		ob.shipDistribution.displayBoard();

		for (Ship ship : ob.ships) {// mam wszystkie jego sttaki
			switch (ship.masts.length) {
			case 1: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						
						
						Coordinates coordinates= new Coordinates((int) (10 * Math.random()), (int) (10 * Math.random()));
						
						
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;
							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;
			}
			case 2: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = new Coordinates((int) (10 * Math.random()), (int) (10 * Math.random()));
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;
			}
			case 3: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = new Coordinates((int) (10 * Math.random()), (int) (10 * Math.random()));
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;

			}
			case 4: {
				do {
					for (int i = 0; i < ship.masts.length; i++) {
						Coordinates coordinates = new Coordinates((int) (10 * Math.random()), (int) (10 * Math.random()));
						if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 0) {
							if (i > 0) {
								boolean properMastPosition = false;

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() - 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() - 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition() + 1][coordinates
											.getHorizontalPosition()] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								try {
									if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
											.getHorizontalPosition() + 1] == 1) {
										System.out.println("Maszt znajduje siê obok innego masztu");
										properMastPosition = true;
									}
								} catch (ArrayIndexOutOfBoundsException a) {
									System.out.println("wysz³em poza plansze");
								}

								if (!properMastPosition) {
									System.out.println("Niedozwolona pozycja!");
									i--;
									continue;
								}
							}

							ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
									.getHorizontalPosition()] = 1;

							ship.masts[i].position = coordinates;
							ship.masts[i].set();
						} else if (ob.shipDistribution.board[coordinates.getVerticalPosition()][coordinates
								.getHorizontalPosition()] == 3) {
							System.out.println("Za blisko innego statku!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						} else {
							System.out.println("Tam ju¿ jest statek!:)");
							System.out.println("Spróbuj jeszcze raz");
							i--;
						}
					}
				} while (!ship.isSet());
				ob.outlineShips();
				System.out.println("statek ustawiony!");
				ob.shipDistribution.displayBoard();
				break;

			}

			}
		}
		ob.shipDistribution.displayBoard();
	}

	public static void shootTheOpponentAutomatically(Player ob1, Player ob2) {// ob1
																				// strzela
																				// do
																				// ob2
		boolean uniqueShot = false;
		Coordinates coordinates = null;

		while (!uniqueShot) {
			coordinates = new Coordinates((int) (10 * Math.random()), (int) (10 * Math.random()));
			if (ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
					.getHorizontalPosition()] == 1
					|| ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
							.getHorizontalPosition()] == 2) {
				uniqueShot = false;
			} else {
				uniqueShot = true;
			}
		}

		if (ob2.shipDistribution.board[coordinates.getVerticalPosition()][coordinates.getHorizontalPosition()] == 0) {
			ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
					.getHorizontalPosition()] = 1;
		} else {
			ob1.previousShotsDistribution.board[coordinates.getVerticalPosition()][coordinates
					.getHorizontalPosition()] = 2;
			ob2.shipDistribution.board[coordinates.getVerticalPosition()][coordinates.getHorizontalPosition()] = 2;
			ob1.incrementHitCounter();
		}
		ob2.shipDistribution.displayBoard();
		Game.player1IsActive = !Game.player1IsActive;
	}

	public static void whoIsTheWinner(Player ob1, Player ob2) {
		if (ob1.getHitCounter() == 20) {
			System.out.println("Player 1 jest zwyciêzc¹!");
			Game.theGameIsOn = false;
		}
		if (ob2.getHitCounter() == 20) {
			System.out.println("Player 2 jest zwyciêzc¹!");
			Game.theGameIsOn = false;
		}
	}
}