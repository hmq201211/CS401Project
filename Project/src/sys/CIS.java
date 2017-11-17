package sys;


import bean.Coupon;
import binarySearchTree.BinarySearchTree;
import list.SortedLinkedList;
import list.UnSortedLinkedList;

import java.util.Comparator;
import java.util.Iterator;


public class CIS {
    //initiate 3 collections which help the system to run
    public static UnSortedLinkedList<Coupon> UL = new UnSortedLinkedList<Coupon>();
    public static SortedLinkedList<Coupon> SL = new SortedLinkedList<Coupon>();
    public static BinarySearchTree<Coupon> BST = new BinarySearchTree<Coupon>();
    //initiate 6 comparators which are based on different attributes
    public static final Comparator<Coupon> CPBProvider = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return o1.getProvider().compareTo(o2.getProvider());
        }
    };
    public static final Comparator<Coupon> CPBNameOfProduct = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return o1.getNameOfProduct().compareTo(o2.getNameOfProduct());
        }
    };
    public static final Comparator<Coupon> CPBPriceOfProduct = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return Double.compare(o1.getPriceOfProduct() * (1 - o1.getRateOfDiscount()), o2.getPriceOfProduct() * (1 - o2.getRateOfDiscount()));
        }
    };
    public static final Comparator<Coupon> CPBRateOfDiscount = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return Double.compare(o1.getRateOfDiscount(), o2.getRateOfDiscount());
        }
    };
    public static final Comparator<Coupon> CPBExpirationPeriod = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return o1.getExpirationPeriod() - o2.getExpirationPeriod();
        }
    };
    public static final Comparator<Coupon> CPBIsUsed = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon o1, Coupon o2) {
            return Boolean.compare(o1.isUsed(), o2.isUsed());
        }
    };

    //add information to the system which help to show the result of the operations
    static {
        UL.add(new Coupon("NIKE", "Shirt", 50, 0.12, 100, false));
        UL.add(new Coupon("ADIDAS", "Shirt", 70, 0.12, 30, false));
        UL.add(new Coupon("PUMA", "Shoes", 52, 0.23, 3, true));
        UL.add(new Coupon("LOL", "Game", 5, 0.21, 1, true));
        UL.add(new Coupon("PUBG", "Game", 7, 0.22, 80, false));
        UL.add(new Coupon("WOW", "Game", 8, 0.24, 78, true));
        UL.add(new Coupon("LG", "TV", 510, 0.02, 30, false));
        UL.add(new Coupon("LOL", "Game", 10, 0.22, 200, true));
        UL.add(new Coupon("NVIDIA", "GPU", 700, 0.12, 200, false));
        UL.add(new Coupon("INTEL", "CPU", 490, 0.24, 10, false));
        UL.add(new Coupon("NVIDIA", "GPU", 496, 0.32, 100, true));
        UL.add(new Coupon("INTEL", "CPU", 390, 0.22, 80, false));
        UL.add(new Coupon("AMD", "CPU", 500, 0.12, 90, true));
        UL.add(new Coupon("AMD", "GPU", 600, 0.42, 70, true));
        UL.add(new Coupon("AMD", "CPU", 300, 0.32, 165, true));
        UL.add(new Coupon("NIKE", "Shirt", 60, 0.12, 20, true));
        UL.add(new Coupon("TIMBERLAND", "Shoes", 100, 0.42, 21, false));
        UL.add(new Coupon("THENORTHFACE", "Puffer", 199, 0.02, 31, true));
        UL.add(new Coupon("LOL", "Game", 15, 0.21, 35, false));
        UL.add(new Coupon("APPLE", "Phone", 999, 0.23, 47, true));
        UL.add(new Coupon("SAMSUNG", "Phone", 790, 0.24, 56, false));
        UL.add(new Coupon("SAMSUNG", "TV", 589, 0.27, 103, false));
        UL.add(new Coupon("SAMSUNG", "TV", 589, 0.27, 103, false));

    }

    //take a String and add the coupon to UL,return the result
    public static String add(String s) {
        UL.add(stringToCoupon(s));
        return "you have successfully added " + s;
    }

    //take a String and search the coupon in the UL and BST and return the result
    public static String search(String s) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        Iterator<Coupon> it = UL.iterator();
        BST = new BinarySearchTree<Coupon>();
        SL = new SortedLinkedList<Coupon>();
        while (it.hasNext()) {
            Coupon temp = it.next();
            BST.add(temp);
            SL.add(temp);
        }
        SortedLinkedList<Integer> sll1 = SL.myFind(stringToCoupon(s));
        SortedLinkedList<Integer> sll2 = BST.myFind(stringToCoupon(s));
        if (sll1.isEmpty() && sll2.isEmpty()) {
            sb.append("there is no coupon as " + s);
            return sb.toString();
        } else {
            sb.append("find coupon " + s + "\n");
            sb.append("in linear search, we find it(them) at the ");
            Iterator<Integer> it1 = sll1.iterator();
            while (it1.hasNext()) {
                count++;
                sb.append(it1.next() + "th,");
            }
            sb.append("comparison, totally " + count + " item(s)\n");
            count = 0;
            sb.append("in binary search, we find it(them) at the ");
            Iterator<Integer> it2 = sll2.iterator();
            while (it2.hasNext()) {
                count++;
                sb.append(it2.next() + "th,");
            }
            sb.append("comparison, totally " + count + " item(s)\n");

        }
        return sb.toString();
    }

    //take a String and try to delete the coupon in the UL and return the result
    public static String delete(String s) {
        boolean flag = UL.remove(stringToCoupon(s));
        if (flag) {
            return "you have successfully deleted " + s;
        } else {
            return "we didn't find any coupon as " + s;
        }
    }

    //find out the coupon which has the smallest expiration period and is not used
    public static String asap() {
        BST = new BinarySearchTree<Coupon>(CPBExpirationPeriod);
        Iterator<Coupon> it = UL.iterator();
        while (it.hasNext()) {
            BST.add(it.next());
        }
        Iterator<Coupon> it2 = BST.iterator();
        while (it2.hasNext()) {
            Coupon temp = it2.next();
            if (temp.isUsed() == false) {
                return temp.toString();
            }
        }
        return "";
    }

    //take a String as an attribute then rank the list based on the attribute and return the result
    public static String list(String s) {
        if (UL.isEmpty()) {
            return "there isn't any items in the system";
        }
        Comparator<Coupon> comp = null;
        switch (s) {
            case "provider":
                comp=CPBProvider;
                break;
            case "name":
                comp = CPBNameOfProduct;
                break;
            case "price":
                comp = CPBPriceOfProduct;
                break;
            case "discount":
                comp = CPBRateOfDiscount;
                break;
            case "expiration":
                comp = CPBExpirationPeriod;
                break;
            case "use":
                comp = CPBIsUsed;
                break;
            default:
                break;

        }
        if (comp != null) {
            BST = new BinarySearchTree<Coupon>(comp);

        } else {
            BST = new BinarySearchTree<Coupon>();
        }
        Iterator<Coupon> iterator1 = UL.iterator();
        while (iterator1.hasNext()) {
            BST.add(iterator1.next());
        }

        Iterator<Coupon> iterator2 = BST.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("According to the " + s + " order, we list the following items..\n");
        sb.append("Provider Name price discount expiration use \n");
        while (iterator2.hasNext()) {
            sb.append(iterator2.next().toString() + "\n");
        }
        return sb.toString();


    }

    //private method which help to convert the String to Coupon
    private static Coupon stringToCoupon(String s) {
        String[] temp = s.split(" ");
        return new Coupon(temp[0], temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Boolean.parseBoolean(temp[5]));
    }


//    public static void main(String[] args) {
//        System.out.println(add("NIKE,Shirt,79,0.2,100,false"));
//        System.out.println(search("NIKE,Shirt,79,0.2,100,false"));
//        System.out.println(list("price"));
//    }


}
