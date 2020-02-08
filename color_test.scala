import scala.util.Random
import scala.io.StdIn.readLine

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
				println("""
                  ___  ___          _           ___  ____           _ 
                  |  \/  |         | |          |  \/  (_)         | |
                  | .  . | __ _ ___| |_ ___ _ __| .  . |_ _ __   __| |
                  | |\/| |/ _` / __| __/ _ \ '__| |\/| | | '_ \ / _` |
                  | |  | | (_| \__ \ ||  __/ |  | |  | | | | | | (_| |
                  \_|  |_/\__,_|___/\__\___|_|  \_|  |_/_|_| |_|\__,_|
                                                                      
                  by: the stallions cohort 9 BOG
                  """)
                println("----READ BEFORE START TO PLAY, THE NEXT INSTRUCCIONS-----\n")
		println("Please select 4 color for you chips\nType the corresponding letter")
		println("Yellow      (Y) -> " + Console.YELLOW + form + Console.RESET)
		println("Red         (R) -> " + Console.RED + form + Console.RESET)
		println("Magenta     (M) -> " + Console.MAGENTA + form + Console.RESET)
		println("Blue        (B) -> " + Console.BLUE + form + Console.RESET)
		println("Green       (G) -> " + Console.GREEN + form + Console.RESET)
		println("White       (W) -> " + Console.WHITE + form + Console.RESET)
                println("\n------------THIS HELP YOU WITH YOUR ANSWER--------------")
                println("\u2713   you have the color and position ok")
                println("~   You only have the color ok" )
                println("X   You have wrong the color and position" )
		println("\nYOU HAVE 10 OPORTUNITIES!\nGOOD LUCK!")

		println("\n_____________________________\n")
	}

	def compare(player: Array[circle], bot: Array[circle]): Int = {
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
		var count = 0
		for (i <- 0 to 3) {
  		if (answer(i) == "\u2713   ") {
		    count += 1
                }
                }
                if(count == 4) {
                  return 1
                } else {
                  return 0
                }
	}
}

object Main {
    def main(args: Array[String]): Unit = {

		var chip_bot:Array[circle]=new Array[circle](4)
		var chip_player:Array[circle]=new Array[circle](4)
		
		Functions.welcome()

		// Set random pattern
		for (i <- 0 to 3) {
			chip_bot(i) = new circle()
	   		//chip_bot(i).print_crl(chip_bot(i).color, chip_bot(i).form)
		}
		//println()
                var flag = true
                while (flag) {
                      // Number of oportunities
                      var cycles: Int = 0
                      while (cycles <= 9) {
                              println("** Game # " + (cycles + 1) + " **")
                              // Player set chips
                              for (i <- 0 to 3) {
                                      chip_player(i) = new circle()
                                      var msn_str = "Set color of chip " + (i + 1) + ":  "
                                      var flag = true
                                      var input_color = ""
                                      while (flag) {
                                              input_color = readLine(msn_str).toUpperCase()
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
                              if (Functions.compare(chip_player, chip_bot) == 1) {
                                    println("""
                                      ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗
                                      ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║
                                       ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║
                                        ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║
                                         ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║
                                         ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝
                                                THANKS FOR PLAYING...  CREDITS:
                                                Carlos Molano
                                                David Peralta
                                                Edward Ortiz
                                                Sebastian Montealegre
                                                Yesid Gutierrez
                                      """)
                                  var play_again: String  = ""
                                  play_again = readLine("Do you want to play again: [Y/N]: ").toUpperCase()
                                  if (play_again.equals("N")) {
                                    flag = false
                                            return
                                  }
                                  cycles = -1
                              }
                              println("\n_____________________________\n")
                              cycles += 1

                      }
                      println("--------- YOU LOSE :'V ------------")
                      println("""
                        ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗ ███████╗███████╗
                        ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔════╝██╔════╝
                         ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║███████╗█████╗
                          ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║╚════██║██╔══╝
                           ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝███████║███████╗
                           ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝╚══════╝
                                  THANKS FOR PLAYING...  CREDITS:
                                  Carlos Molano
                                  David Peralta
                                  Edward Ortiz
                                  Sebastian Montealegre
                                  Yesid Gutierrez
                        """)
                      var play_again: String  = ""
                      play_again = readLine("Do you want to play again: [Y/N]: ").toUpperCase()
                      if (play_again.equals("N")) {
                        flag = false
                      }
                }
    }
}
