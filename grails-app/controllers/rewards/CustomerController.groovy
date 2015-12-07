package rewards

class CustomerController {
    static scaffold  =  Customer
    def checkin() {}
    def lookup() {
                 def customerInstance = Customer.list()

//        def customerInstance = Customer.findAllByTotalPoints(params.id)
//        def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThanEquals("B%", 1)

        [customerInstanceList: customerInstance]


    }

       def index() {

           params.max = 10
           def customerInstance = Customer.list(params)

           [customerInstanceList: customerInstance, customerInstanceCount: Customer.count()]

       }

    def creat() {
        params.max = 10
        [customerInstance: new Customer() ]
    }

}
