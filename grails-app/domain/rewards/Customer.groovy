package rewards

class Customer {
    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints

    static hasMany = [award:Award, orders:OnlineOrder]

    static constraints = {
    }
}
