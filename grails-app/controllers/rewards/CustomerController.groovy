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

       def index(Integer max) {



           params.max = Math.min(max ?: 10, 100)
           respond Customer.list(params), model:[customerCount: Customer.count()]

       }

    def creat() {


        respond new Customer(params)
    }





    def show(Customer customer) {

        respond customer
  }



}
