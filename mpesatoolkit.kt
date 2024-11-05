fun main(){

    val userPin ="1234"
    var balance= 60000.00
    val enteredPin: String?
    var mShwariBalance=3500.0 //added Mshwari balance
    var kcbMpesaBalance=5520.0

        //user login
    val attempts =3
    for (attempt in 1..attempts){
       println("Enter your 4-digit pin : ")
       val enteredPin =readLine()

        if (enteredPin == userPin){
            println("Login successful")
            operationsMenu(balance, userPin,mShwariBalance, kcbMpesaBalance) // Pass userPin to the operations menu
            return // Exit after calling operationsMenu
        }
        else{
            println("Incorrect PIN. You have ${attempts - attempt} attempts left.")
        }
    }
    println("Too many attempts. PIN blocked")
}
    

//Operations menu function
fun operationsMenu(balance: Double, userPin: String, mShwariBalance: Double, kcbMpesaBalance: Double) {
    var currentBalance = balance // Mutable variable to track the current balance
    var currentMShwariBalance = mShwariBalance //Mutable variable for M-Shwari balance
    var currentkcbMpesaBalance = kcbMpesaBalance


    while(true){
        println("\nChoose an operation: ")
        println("1. Send Money")
        println("2. Withdraw cash")
        println("3. Buy Airtime")
        println("4. Lipa na MPESA")
        println("5. Loans and Savings")
        println("6. My Account")
        println("7. Exit")

        println("Enter your choice(1-7): ")
            //read the user's input
        val choice = readLine()?.toIntOrNull()
        
        if (choice != null) {
            when (choice) {
                1 -> {
                    // Send Money functionality
                    print("Enter the recipient's phone number: ")
                    val recipientPhoneNumber = readLine()
                    
                    print("Enter amount to send: ")
                    val sendAmount = readLine()?.toDoubleOrNull()

                    if (sendAmount != null && sendAmount > 0) {
                        if (sendAmount > currentBalance) {
                            println("Insufficient balance. Your current balance is: $currentBalance")
                        } else {
                            print("Please enter your PIN to confirm the transaction: ")
                            val confirmPin = readLine()

                            if (confirmPin == userPin) {
                                currentBalance -= sendAmount // Deduct amount from current balance
                                println("You have successfully sent $sendAmount to $recipientPhoneNumber.")
                                println("Your remaining balance is: $currentBalance")
                            } else {
                                println("Incorrect PIN. Transaction cancelled.")
                            }
                        }
                    } else {
                        println("Invalid amount. Please enter a valid amount.")
                    }
                }
                2 ->{
                    //Withdraw money functionality
                    println("Enter the Agent number: ")
                    val agentNumber = readLine()
                    println("Enter Amount to Withdraw: ")
                    val withdrawAmount = readLine()?.toDoubleOrNull()
                    if (withdrawAmount != null) {
                        if (withdrawAmount > currentBalance) {
                            println("Insufficient balance. Your current balance is: $currentBalance")
                        } 
                        else {
                            print("Please enter your PIN to confirm the transaction: ")
                            val confirmPin = readLine()

                            if (confirmPin == userPin) {
                            currentBalance -= withdrawAmount
                            println("Your withdrawal of $withdrawAmount from $agentNumber was successful.")
                            println("Your remaining balance is: $currentBalance")
                        }
                    }
                    }   
                    else {
                        println("Invalid input. Please enter a valid amount.")
                    }
                }
                
                3 -> {
                    //functionality to buy airtime
                    println("\nOptions")
                    println("1. My phone")
                    println("2. Other Phone")

                    println("Enter your option(1-3): ")
                    val option = readLine()?.toIntOrNull()

                         if (option != null) {
                            when(option){
                                1 -> {
                                    println("Enter amount to buy: ")
                                    val buyAirtime =readLine()?.toDoubleOrNull()
                                    if (buyAirtime !=null){
                                        if(buyAirtime>currentBalance){
                                            println("Insufficient balance. Your current balance is: $currentBalance")
                                        }
                                        else{
                                           println("Please enter your PIN: ") 
                                           val confirmPin = readLine()
                                           if (confirmPin == userPin){
                                            currentBalance -=buyAirtime
                                            println("You bought airtime of $buyAirtime. Your remaining balance is: $currentBalance")
                                           }
                                        }
                                    }
                                    else{
                                        println("Invalid amount. Please enter a valid amount.")
                                        }
                                }
                                2 -> {
                                    println("Enter phone number: ")
                                    val recipientPhoneNumber = readLine()
                                    println("Enter amount to buy: ")
                                    val buyAirtime =readLine()?.toDoubleOrNull()
                                    if (buyAirtime !=null){
                                        if(buyAirtime>currentBalance){
                                            println("Insufficient balance. Your current balance is: $currentBalance")
                                        }
                                        else{
                                           println("Please enter your PIN: ") 
                                           val confirmPin = readLine()
                                           if (confirmPin == userPin){
                                            currentBalance -=buyAirtime
                                            println("You bought airtime of $buyAirtime. Your remaining balance is: $currentBalance")
                                           }
                                        }
                                    }
                                    else{
                                        println("Invalid amount. Please enter a valid amount.")
                                        }                                    
                                }
                            }
                         }

                }
                4 -> {
                    println("Lipa na MPESA feature is not yet implemented.")
                }
                5 -> {
                    println("\nLoan Options")
                    println("1. M-Shwari")
                    println("2. KCB MPESA")

                    println("Enter an option: ")
                    val lOption= readLine()?.toIntOrNull()

                    if (lOption !=null){
                        when(lOption){
                            1 ->{
                                println("\nM-Shwari options")
                                println("a. Send to M-Shwari")
                                println("b. Withdraw from M-Shwari")
                                println("c. Lock Savings Account")
                                println("d. Check balance")

                                println("Enter an option: ")
                                val mOption= readLine()

                                    when(mOption){
                                        "a"->{
                                            //var currentBalance = m-shwari
                                            println("Enter the amount to send: ")
                                            val depositAmount = readLine()?.toDoubleOrNull()
                                            if(depositAmount !=null && depositAmount >0){
                                                if(depositAmount<= currentBalance){
                                                    currentBalance -= depositAmount //deduct from the current balance
                                                    currentMShwariBalance += depositAmount
                                                    if(depositAmount>currentBalance){
                                                        println("Insufficient funds. Please try again!")
                                                    }
                                                    else{
                                                        println("Please enter your PIN to complete transaction: ")
                                                        val confirmPin= readLine()
                                                        if(confirmPin == userPin)
                                                        println("A deposit of $depositAmount to M-Shwari was successful.")
                                                        println("Your M-Shwari balance is: $currentMShwariBalance. Your remaining balance is: $currentBalance")
                                                    }

                                                }
                                                else{
                                                    println("Invalid input. Please enter a valid amount")
                                                }
                                                
                                            }
                                        }
                                        "b"->{ //withdraw from M-Shwari functionality
                                            println("Enter the amount to Withdraw: ")
                                            val withdrawAmount = readLine()?.toDoubleOrNull()
                                            if(withdrawAmount != null && withdrawAmount>0){
                                                if(withdrawAmount<= currentMShwariBalance){
                                                    currentMShwariBalance -=withdrawAmount
                                                    currentBalance += withdrawAmount
                                                    if(withdrawAmount>currentMShwariBalance){
                                                        println("Insufficient balance. Your M-Shwari balance is: $currentMShwariBalance")
                                                    }
                                                    else{
                                                        println("Enter your PIN: ")
                                                        val confirmPin = readLine()
                                                        if(confirmPin == userPin){
                                                            println("You have successfully withdrawn $withdrawAmount from M-Shwari")
                                                            println("Your M-Shwari Balance is: $currentMShwariBalance. Your main account balance is: $currentBalance")
                                                        }
                                                    }
                                                }
                                                else{
                                                    println("Invalid amount. Please enter a valid amount")
                                                    }
                                            }
                                        }
                                        "c"->{ //Lock Savings Account functionality
                                            println("Please enter the amount to save in lock savings: ")
                                            val lockAmount = readLine()?.toDoubleOrNull()
                                            if(lockAmount != null && lockAmount >0){
                                                if(lockAmount <=currentMShwariBalance){
                                                    currentMShwariBalance -=lockAmount
                                                    if(lockAmount>currentMShwariBalance){
                                                        println("Insufficient funds. Your M-Shwari balance is: $currentMShwariBalance")
                                                    }
                                                    else{
                                                    println("Enter your PIN: ")
                                                    val confirmPin = readLine()
                                                    if(confirmPin == userPin){
                                                    println("You have successfully locked: $lockAmount to your Lock Savings Account")
                                                    println("New Lock Savings balance: $lockAmount. M-Shwari balance is: $currentMShwariBalance")
                                                    }
                                                }
                                                }
                                                else{
                                                    println("Invalid amount. Please enter a valid amount")
                                                    }
                                            }
                                        }
                                        "d"->{//check M-Shwari balance funtionality
                                            println("Please enter your PIN: ")
                                            val confirmPin = readLine()
                                            if(confirmPin == userPin){
                                                println("Your M-Shwari balance is: $currentMShwariBalance")
                                            }
                                            else{
                                                println("Invalid input. Please try again")
                                            }
                                        }
                                    }
                                
                            }
                            2 -> {  //KCB MPESA Funtion
                                println("\nKCB MPESA options")
                                println("a. Deposit from MPESA")
                                println("b. Withdraw to MPESA")
                                println("c. Fixed Savings Account")
                                println("d. Check balance")

                                println("Enter an option: ")
                                val kOption= readLine()

                                    when(kOption){
                                        "a"->{
                                            //var currentBalance = m-shwari
                                            println("Enter the amount to deposit: ")
                                            val depositAmount = readLine()?.toDoubleOrNull()
                                            if(depositAmount !=null && depositAmount >0){
                                                if(depositAmount<= currentBalance){
                                                    currentBalance -= depositAmount //deduct from the current balance
                                                    currentkcbMpesaBalance += depositAmount
                                                    if(depositAmount>currentBalance){
                                                        println("Please enter your PIN to complete transaction: ")
                                                        val confirmPin= readLine()
                                                        if(confirmPin == userPin){
                                                        println("Insufficient funds. Please try again!")
                                                        }
                                                    }
                                                    else{
                                                        println("A deposit of $depositAmount to KCB MPESA was successful.")
                                                        println("Your KCB MPESA balance is: $currentkcbMpesaBalance. Your remaining balance is: $currentBalance")
                                                    }

                                                }
                                                else{
                                                    println("Invalid input. Please enter a valid amount")
                                                }
                                                
                                            }
                                        }
                                        "b"->{ //withdraw from KCB MPESA functionality
                                            println("Enter the amount to Withdraw: ")
                                            val withdrawAmount = readLine()?.toDoubleOrNull()
                                            if(withdrawAmount != null && withdrawAmount>0){
                                                if(withdrawAmount<= currentkcbMpesaBalance){
                                                    currentkcbMpesaBalance -=withdrawAmount
                                                    currentBalance += withdrawAmount
                                                    if(withdrawAmount>currentkcbMpesaBalance){
                                                        println("Insufficient KCB MPESA balance. Your balance is: $currentkcbMpesaBalance")

                                                    }
                                                    else{
                                                    println("Enter your PIN: ")
                                                    val confirmPin = readLine()
                                                    if(confirmPin == userPin){
                                                    println("You have successfully withdrawn $withdrawAmount from KCB MPESA")
                                                    println("Your KCB MPESA Balance is: $currentkcbMpesaBalance. Your main account balance is: $currentBalance")
                                                    }
                                                }
                                                }
                                                else{
                                                    println("Invalid amount. Please enter a valid amount")
                                                    }
                                            }
                                        }
                                        "c"->{ //Fixed Savings Account functionality
                                            println("Please enter the amount to save in fixed savings: ")
                                            val fixedAmount = readLine()?.toDoubleOrNull()
                                            if(fixedAmount != null && fixedAmount >0){
                                                if(fixedAmount <=currentkcbMpesaBalance){
                                                    currentkcbMpesaBalance -=fixedAmount
                                                    if(fixedAmount>currentkcbMpesaBalance){
                                                        println("Insufficient funds. Your KCB MPESA balance is: $currentkcbMpesaBalance")

                                                    }
                                                    else{
                                                    println("Enter your PIN: ")
                                                    val confirmPin = readLine()
                                                    if(confirmPin == userPin){
                                                    println("You have successfully saved: $fixedAmount to your Fixed Savings Account")
                                                    println("New Fixed Savings balance: $fixedAmount. KCB MPESA balance is: $currentkcbMpesaBalance")
                                                    }
                                                }
                                                }
                                                else{
                                                    println("Invalid amount. Please enter a valid amount")
                                                    }
                                            }
                                        }
                                        "d"->{//check KCB MPESA balance funtionality
                                            println("Please enter your PIN: ")
                                            val confirmPin = readLine()
                                            if(confirmPin == userPin){
                                                println("Your KCB MPESA balance is: $currentkcbMpesaBalance")
                                            }
                                            else{
                                                println("Invalid input. Please try again")
                                            }
                                        }
                                    }
                            }
                        }
                    }
                }
                6 -> {
                    println("Your current balance is: $currentBalance")
                }
                7 -> {
                    println("Exiting the application.")
                    return
                }
                else -> {
                    println("Invalid choice. Please select a valid option.")
                }
            }
        } else {
            println("Invalid input. Please enter a number between 1 and 7.")
        }
    }
}
           