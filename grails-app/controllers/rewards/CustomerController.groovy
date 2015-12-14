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
