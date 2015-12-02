package rewards

class InventoryController {

    def index() {
        render "Here is a list of everythings."
    }

    def edit() {

        def productName = "Breakfast Blend"
        def sku = "BB01"
                [product:productName, sku:sku]



    }
    
    def remove() {
        render "This is the remove testing."
    }


    def list(){
        def allProducts = Product.list()
        [allProducts:allProducts]

    }

}
