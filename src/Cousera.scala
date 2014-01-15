object Cousera {

	def pascal(c:Int,r:Int):Int={
			if(c==0)1
			else if(r==0)0
			else pascal(c-1, r-1) + pascal(c, r-1)
	}

	def balance(chars:List[Char]):Boolean={
			@annotation.tailrec
			def loop(chars:List[Char],open:Int,close:Int):Boolean={
					if(chars.isEmpty) if(open-close==0)true else false
					else
						if(chars.head == '(') loop(chars.tail,open+1,close)
						else if(chars.head == ')') 
						{
							if (close+1>open)false
							else loop(chars.tail,open,close+1)
						}
						else loop(chars.tail,open,close)
			}
			loop(chars,0,0)
	}

	def countChange(monto: Int, monedasIniciales: List[Int]): Int={
			def loop(suma:Int,monedasRestantes: List[Int]):Int={
					if(suma<0) 0
					else if(monedasRestantes.isEmpty) 
					{
						if(suma == 0) 1 else 0
					}
					else loop(suma, monedasRestantes.tail) + loop(suma-monedasRestantes.head, monedasRestantes)
			}
			loop(monto, monedasIniciales)
	}


	def main(args: Array[String]) {

		println("")
		println("----------------------------------------------")
		println("Pascal")
		println("----------------------------------------------")
		println("Pascal de 0,2 => "+pascal(0,2))
		println("Pascal de 1,2 => "+pascal(1,2))
		println("Pascal de 2,3 => "+pascal(2,3))
		println("Pascal de 2,4 => "+pascal(2,4))

		println("")
		println("----------------------------------------------")
		println("Validacion de parentesis")
		println("----------------------------------------------")
		println("Validar los parentesis de la cadena (if (zero? x) max (/ 1 x)) => "+balance("(if (zero? x) max (/ 1 x))".toList))
		println("Validar los parentesis de la cadena I told him (that it’s not (yet) done). (But he wasn’t listening) => "+balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
		println("Validar los parentesis de la cadena :-) => "+balance(":-)".toList))
		println("Validar los parentesis de la cadena ())( => "+balance("())(".toList))
		println("Validar los parentesis de la cadena jbasjbd(hbf((((bdbkjsdf)))gfkf)))9nkjndsfkj((((((((((((((( => "+balance("jbasjbd(hbf((((bdbkjsdf)))gfkf)))9nkjndsfkj(((((((((((((((".toList))
		println("Validar los parentesis de la cadena jnskfns(((bsadbjh)bfdjhbd))()((())) => "+balance("jnskfns(((bsadbjh)bfdjhbd))()((()))".toList))
		println("Validar los parentesis de la cadena badbjh)bhdsf)k8(iu) => "+balance("badbjh)bhdsf)k8(iu)".toList))

		println("")
		println("----------------------------------------------")
		println("Problema del cambio de monedas")
		println("----------------------------------------------")
		println("Si quiero cambiar 200 pesos en monedas de 100 y 200 hay "+countChange(200, List(100,200))+" posibilidades de hacerlo")
		println("Si quiero cambiar 1000 pesos en monedas de 100 y 200 hay "+countChange(1000, List(100,200))+" posibilidades de hacerlo")
		println("Si quiero cambiar 1000 pesos en monedas de 100 , 200 y 500 hay "+countChange(1000, List(100,200,500))+" posibilidades de hacerlo")
		println("Si quiero cambiar 15000 pesos en monedas de 50, 100, 200, 500 y 1000 hay "+countChange(15000, List(50,100,200,500,1000))+" posibilidades de hacerlo")
		println("Si quiero cambiar 500000 de pesos en monedas de 200, 500 y 1000 hay "+countChange(500000, List(200,500,1000))+" posibilidades de hacerlo")

	}
}