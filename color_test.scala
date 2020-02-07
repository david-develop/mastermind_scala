import scala.util.Random

class circle {
    val colors: List[String] = List("R", "Y", "G", "B", "W", "M")
    val random = new Random
    var color = colors(random.nextInt(colors.length))
    val form = "\u2B24   "
    def print_crl (color: String, form: String) : Unit = {
		if (color == "Y") {
			print(Console.YELLOW + form + Console.RESET)
		} else if (color == "R") {
			print(Console.RED + form + Console.RESET)
		} else if (color == "B") {
			print(Console.BLUE + form + Console.RESET)
		} else if (color == "G") {
			print(Console.GREEN + form + Console.RESET)
		} else if (color == "W") {
			print(Console.WHITE + form + Console.RESET)
		} else if (color == "M") {
			print(Console.MAGENTA + form + Console.RESET)
		}
    }
}

object Functions {
	def welcome() : Unit = {
		// Welcome message
		val form = "\u2B24   "
		println("Welcome to mastermind of Stalion Team, BOG-Cohort-9")
		println("Please select 4 color for you chips\nType the corresponding letter UPPERCASE")
		println("Yellow      (Y) -> " + Console.YELLOW + form + Console.RESET)
		println("Red         (R) -> " + Console.RED + form + Console.RESET)
		println("Magenta     (M) -> " + Console.MAGENTA + form + Console.RESET)
		println("Blue        (B) -> " + Console.BLUE + form + Console.RESET)
		println("Green       (G) -> " + Console.GREEN + form + Console.RESET)
		println("White       (W) -> " + Console.WHITE + form + Console.RESET)
		println("\nYOU HAVE 10 OPORTUNITIES!\nGOOD LUCK!")

		println("\n_____________________________\n")
	}

	def compare(player: Array[circle], bot: Array[circle]): Array[String] = {
		var answer: Array[String]=new Array[String](4)
		var colors: Array[String]=new Array[String](4)

		// Create a list of colors (string)
		for (i <- 0 to 3) {
			colors(i) = bot(i).color
		}

		for (i <- 0 to 3) {
			if (colors.contains(player(i).color) && player(i).color == colors(i)) {
				answer(i) = "\u2713   " // 2
			} else if (colors.contains(player(i).color)) {
				answer(i) = "~   " // 1
			} else {
				answer(i) = "X   " // 0
			} 
		}
		answer.foreach(print)
		(answer)

	}
}

object Main {
    def main(args: Array[String]) {

		var chip_bot:Array[circle]=new Array[circle](4)
		var chip_player:Array[circle]=new Array[circle](4)
		
		Functions.welcome()

		// Set random pattern
		for (i <- 0 to 3) {
			chip_bot(i) = new circle()
	   		//chip_bot(i).print_crl(chip_bot(i).color, chip_bot(i).form)
		}
		//println()

		// Number of oportunities
		for (cycles <- 0 to 9) {
			println("** Game # " + (cycles + 1) + " **")
			// Player set chips
			for (i <- 0 to 3) {
				chip_player(i) = new circle()
				var msn_str = "Set color of chip " + (i + 1) + ":  "
				var flag = true
				var input_color = ""
				while (flag) {
					input_color = readLine(msn_str)
					if (chip_player(i).colors.contains(input_color)) {
						flag = false
					} else {
						println("Color doesn't exist, try again!")
					}
				}
				chip_player(i).color = input_color
			}

			// Print player chips
			for (i <- 0 to 3) {
				chip_player(i).print_crl(chip_player(i).color, chip_player(i).form)
			}
			Functions.compare(chip_player, chip_bot)
			println("\n_____________________________\n")
		}
	}
}