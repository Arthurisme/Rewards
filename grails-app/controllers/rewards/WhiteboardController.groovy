package rewards

class WhiteboardController {

    def calculationsService
    def index() {}

    def variables(){
        def myTotal = 1
        render ("Total: "+myTotal)
        render ("</br>"+myTotal.class)
        myTotal = myTotal + 1
        render ("</br> New Total: "+myTotal)

        def firstName = "Arthur"
        render ("</br></br> Name: "+firstName)
        render ("</br>"+firstName.class)
        firstName = firstName + 1
        render ("</br> New Total: "+firstName)

        def today = new Date()
        render ("</br></br> Today: "+today)
        render ("</br>"+today.class)
        today = today + 1
        render ("</br> New date: "+today)
    }

    def conditions(){

        def welcomeMessage = calculationsService.welcome(params)
//        def welcomeMessage = "test"

        render welcomeMessage

    }
}
