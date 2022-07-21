public class Application {

    public static void main(String[] args) {


        CareTaker careTaker = new CareTaker();
        Cart cart = new Cart();
        cart.addItem(new Item("Pen"));
        cart.addItem(new Item("Pencil"));

        careTaker.save(cart);
        System.out.println(cart);

        cart.addItem(new Item("scfdgr"));
        careTaker.save(cart);
        System.out.println(cart);
        cart.addItem(new Item("efegyt"));
        careTaker.save(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
    }

}