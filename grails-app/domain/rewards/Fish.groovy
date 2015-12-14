package rewards

class Fish {

    String fishName
//    String fishColor

    //static  hasOne = [fish:Fish]
//    static  hasMany = [fish:Fish]

  //SortedSet subItems
    static hasMany = [subItems: Fish]
    static belongsTo = [parent: Fish]


    static constraints = {
        fishName()
        parent(nullable:true)
        subItems(nullable:true)


    }
}
