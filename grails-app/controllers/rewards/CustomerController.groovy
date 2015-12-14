package rewards

class CustomerController {
    def calculationsService

    static scaffold  =  Customer
    def checkin() {}
    def lookup() {
                 def customerInstance = Customer.list()

//        def customerInstance = Customer.findAllByTotalPoints(params.id)
//        def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThanEquals("B%", 1)

        [customerInstanceList: customerInstance]


    }

    def customerLookup(Customer lookupInstance) {

        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)

        render(view:"checkin" , model:[customerInstance: customerInstance, welcomeMessage:welcomeMessage])


        //Query customer by phone #
        //if no result
        //   create a new customer
        //   add award record
        //   save customer
        //   send customer to kiosk
        // if customer found,
        //   calculate total points
        //   create welcome page
        //   add award record
        //   save customer
        //    Send welcometo kiosk
        //save customer



    }

       def index(Integer max) {



           params.max = Math.min(max ?: 10, 100)
           respond Customer.list(params), model:[customerCount: Customer.count()]

       }

    def creat() {


        respond new Customer(params)
    }





    def show(Customer customer) {

        def customerInstance = customer

        customerInstance = calculationsService.getTotalPoints(customerInstance)
//        respond customer
        respond customerInstance
//        [customerInstance: customerInstance]


  }



}
