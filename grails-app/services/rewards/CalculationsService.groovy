package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {

        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = "hh"
        switch (totalPoints){

            case 5:
                welcomeMessage = "Welcome back $firstName. This drink is on us"
                break

            case 4:
                welcomeMessage = "Welcome back $firstName. This drink is free"
                break
            case 2..3:
                welcomeMessage = "Welcome back $firstName. You now have $totalPoints points"
                break
            default:
                welcomeMessage = "Welcome back $firstName. Thank you for registering"
                break

        }
//return welcomeMessage
    }

    def getTotalPoints(customerInstance){
        def totalAwards = 0
         customerInstance.award.each{
             totalAwards = totalAwards + it.points
         }
        customerInstance.totalPoints = totalAwards
        return customerInstance
    }

    def processCheckin(lookupInstance){

        def welcomeMessage = ""

        //Lookup customer by phone number
        def customerInstance = Customer.findByPhone(lookupInstance.phone)
        //Set up new customer
        if(customerInstance == null)
        {
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
        }
        //Calculate current award points
        def totalAwards = 0
        customerInstance.award.each{
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards
//        return customerInstance
        //Create welcome message
        switch (totalAwards){

            case 5:
                welcomeMessage = "Welcome back $customerInstance.firstName. This drink is on us"
                break

            case 4:
                welcomeMessage = "Welcome back $customerInstance.firstName. This drink is free"
                break
            case 2..3:
                welcomeMessage = "Welcome back $customerInstance.firstName. You now have ${totalAwards+1} points"
                break
            default:
                welcomeMessage = "Welcome back $customerInstance.firstName. Thank you for registering"
                break

        }
        //Add new award
        if(totalAwards < 5){
            customerInstance.addToAward(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        }else{
            customerInstance.addToAward(new Award(awardDate: new Date(), type: "Reward", points: -5))

        }
        //Save customer
        customerInstance.save()


//        def customerInstance = lookupInstance
//        def welcomeMessage = "Welcome bace Haha."

        return [customerInstance, welcomeMessage]
    }



}
