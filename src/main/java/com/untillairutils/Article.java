package com.untillairutils;

public class Article {
	public String name;
	public String number;
	public double price;
	public String department;
	public String foodGroup;
	public String category;

	public Article(String name, String number, double price, String department, String foodGroup, String category) {
		this.name = name;
		this.number = number;
		this.price = price;
		this.department = department;
		this.foodGroup = foodGroup;
		this.category = category;
	}

	public static Article[] getTestArticles() {

		Article[] articles = new Article[100];
		articles[0] = new Article("Coca-Cola", "001", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[1] = new Article("Pepsi", "002", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[2] = new Article("Sprite", "003", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[3] = new Article("Fanta", "004", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[4] = new Article("Mineral water", "005", 1.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[5] = new Article("Beer", "006", 4.5, "Cold drinks", "Drinks with alcohol", "Drinks");
		articles[6] = new Article("Wine", "007", 6.5, "Cold drinks", "Drinks with alcohol", "Drinks");
		articles[7] = new Article("Cider", "008", 4.5, "Cold drinks", "Drinks with alcohol", "Drinks");
		articles[8] = new Article("Mixed salad", "009", 8.5, "Salads", "Cold kitchen", "Food");
		articles[9] = new Article("Greek salad", "010", 10.5, "Salads", "Cold kitchen", "Food");
		articles[10] = new Article("Caesar salad", "011", 11.5, "Salads", "Cold kitchen", "Food");
		articles[11] = new Article("Tomato soup", "012", 7.5, "Soups", "Hot kitchen", "Food");
		articles[12] = new Article("Chicken soup", "013", 7.5, "Soups", "Hot kitchen", "Food");
		articles[13] = new Article("Beef soup", "014", 7.5, "Soups", "Hot kitchen", "Food");
		articles[14] = new Article("Ravioli", "015", 12.5, "Pasta", "Hot kitchen", "Food");
		articles[15] = new Article("Spaghetti", "016", 10.5, "Pasta", "Hot kitchen", "Food");
		articles[16] = new Article("Lasagna", "017", 14.5, "Pasta", "Hot kitchen", "Food");
		articles[17] = new Article("Pizza Margherita", "018", 13.5, "Pizza", "Hot kitchen", "Food");
		articles[18] = new Article("Pizza Pepperoni", "019", 14.5, "Pizza", "Hot kitchen", "Food");
		articles[19] = new Article("Hamburger", "020", 9.5, "Burgers", "Hot kitchen", "Food");
		articles[20] = new Article("Cheeseburger", "021", 10.5, "Burgers", "Hot kitchen", "Food");
		articles[21] = new Article("Chicken burger", "022", 11.5, "Burgers", "Hot kitchen", "Food");
		articles[22] = new Article("French fries", "023", 4.5, "Sides", "Hot kitchen", "Food");
		articles[23] = new Article("Onion rings", "024", 5.5, "Sides", "Hot kitchen", "Food");
		articles[24] = new Article("Fried chicken wings", "025", 8.5, "Sides", "Hot kitchen", "Food");
		articles[25] = new Article("Spring rolls", "026", 9.5, "Chinese meals", "Hot kitchen", "Food");
		articles[26] = new Article("Fried rice", "027", 8.5, "Chinese meals", "Hot kitchen", "Food");
		articles[27] = new Article("Chow mein", "028", 9.5, "Chinese meals", "Hot kitchen", "Food");
		articles[28] = new Article("Peking duck", "029", 18.5, "Chinese meals", "Hot kitchen", "Food");
		articles[29] = new Article("General Tso chicken", "030", 12.5, "Chinese meals", "Hot kitchen", "Food");
		articles[30] = new Article("Lemon chicken", "031", 11.5, "Chinese meals", "Hot kitchen", "Food");
		articles[31] = new Article("Beef with broccoli", "032", 12.5, "Chinese meals", "Hot kitchen", "Food");
		articles[32] = new Article("Sweet and sour pork", "033", 11.5, "Chinese meals", "Hot kitchen", "Food");
		articles[33] = new Article("Egg drop soup", "034", 7.5, "Chinese meals", "Hot kitchen", "Food");
		articles[34] = new Article("Hot and sour soup", "035", 8.5, "Chinese meals", "Hot kitchen", "Food");
		articles[35] = new Article("Moo shu pork", "036", 12.5, "Chinese meals", "Hot kitchen", "Food");
		articles[36] = new Article("Coke Zero", "037", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[37] = new Article("Lemonade", "038", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[38] = new Article("Ginger ale", "039", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[39] = new Article("Rootbeer", "040", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[40] = new Article("Ice tea", "041", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[41] = new Article("Lemon iced tea", "042", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[42] = new Article("Coca-Cola", "043", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[43] = new Article("Sprite", "044", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[44] = new Article("Fanta Orange", "045", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[45] = new Article("Mountain Dew", "046", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[46] = new Article("Pepsi", "047", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[47] = new Article("Dr. Pepper", "048", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[48] = new Article("7-Up", "049", 2.5, "Cold drinks", "Drinks without alcohol", "Drinks");
		articles[49] = new Article("Red wine", "050", 15.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[50] = new Article("White wine", "051", 16.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[51] = new Article("Chardonnay", "052", 18.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[52] = new Article("Pinot Noir", "053", 21.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[53] = new Article("Cabernet Sauvignon", "054", 22.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[54] = new Article("Merlot", "055", 19.5, "Wine", "Drinks with alcohol", "Drinks");
		articles[55] = new Article("Sangria", "056", 13.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[56] = new Article("Margarita", "057", 10.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[57] = new Article("Martini", "058", 12.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[58] = new Article("Mojito", "059", 11.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[59] = new Article("Cosmopolitan", "060", 12.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[60] = new Article("Long Island Iced Tea", "061", 13.5, "Cocktails", "Drinks with alcohol", "Drinks");
		articles[61] = new Article("Caesar salad", "062", 8.5, "Salads", "Cold kitchen", "Food");
		articles[62] = new Article("Greek salad", "063", 8.5, "Salads", "Cold kitchen", "Food");
		articles[63] = new Article("Caprese salad", "064", 9.5, "Salads", "Cold kitchen", "Food");
		articles[64] = new Article("Tuna salad", "065", 9.5, "Salads", "Cold kitchen", "Food");
		articles[65] = new Article("Cobb salad", "066", 10.5, "Salads", "Cold kitchen", "Food");
		articles[66] = new Article("Caesar wrap", "067", 8.5, "Wraps", "Cold kitchen", "Food");
		articles[67] = new Article("Greek wrap", "068", 8.5, "Wraps", "Cold kitchen", "Food");
		articles[68] = new Article("Chicken Caesar wrap", "069", 9.5, "Wraps", "Cold kitchen", "Food");
		articles[69] = new Article("Turkey club wrap", "070", 10.5, "Wraps", "Cold kitchen", "Food");
		articles[70] = new Article("Veggie wrap", "071", 8.5, "Wraps", "Cold kitchen", "Food");
		articles[71] = new Article("Hamburger", "072", 11.5, "Burgers", "Hot kitchen", "Food");
		articles[72] = new Article("Cheeseburger", "073", 12.5, "Burgers", "Hot kitchen", "Food");
		articles[73] = new Article("Bacon cheeseburger", "074", 13.5, "Burgers", "Hot kitchen", "Food");
		articles[74] = new Article("Chicken sandwich", "075", 10.5, "Sandwiches", "Hot kitchen", "Food");
		articles[75] = new Article("BLT sandwich", "076", 9.5, "Sandwiches", "Cold kitchen", "Food");
		articles[76] = new Article("Club sandwich", "077", 11.5, "Sandwiches", "Cold kitchen", "Food");
		articles[77] = new Article("Grilled cheese sandwich", "078", 8.5, "Sandwiches", "Hot kitchen", "Food");
		articles[78] = new Article("Philly cheesesteak", "079", 12.5, "Sandwiches", "Hot kitchen", "Food");
		articles[79] = new Article("Meatball sub", "080", 11.5, "Sandwiches", "Hot kitchen", "Food");
		articles[80] = new Article("Beef fajitas", "081", 13.5, "Mexican", "Hot kitchen", "Food");
		articles[81] = new Article("Chicken fajitas", "082", 12.5, "Mexican", "Hot kitchen", "Food");
		articles[82] = new Article("Beef tacos", "083", 10.5, "Mexican", "Hot kitchen", "Food");
		articles[83] = new Article("Chicken tacos", "084", 9.5, "Mexican", "Hot kitchen", "Food");
		articles[84] = new Article("Beef burritos", "085", 11.5, "Mexican", "Hot kitchen", "Food");
		articles[85] = new Article("Chicken burritos", "086", 10.5, "Mexican", "Hot kitchen", "Food");
		articles[86] = new Article("Guacamole", "087", 5.5, "Sides", "Cold kitchen", "Food");
		articles[87] = new Article("French fries", "088", 3.5, "Sides", "Hot kitchen", "Food");
		articles[88] = new Article("Onion rings", "089", 4.5, "Sides", "Hot kitchen", "Food");
		articles[89] = new Article("Garlic bread", "090", 4.5, "Sides", "Hot kitchen", "Food");
		articles[90] = new Article("Cheese sticks", "091", 6.5, "Sides", "Hot kitchen", "Food");
		articles[91] = new Article("Garlic mashed potatoes", "092", 4.5, "Sides", "Hot kitchen", "Food");
		articles[92] = new Article("Baked potato", "093", 4.5, "Sides", "Hot kitchen", "Food");
		articles[93] = new Article("Broccoli", "094", 3.5, "Sides", "Hot kitchen", "Food");
		articles[94] = new Article("Carrots", "095", 3.5, "Sides", "Cold kitchen", "Food");
		articles[95] = new Article("Green beans", "096", 3.5, "Sides", "Hot kitchen", "Food");
		articles[96] = new Article("Coke", "097", 2.5, "Soft drinks", "Drinks without alcohol", "Drinks");
		articles[97] = new Article("Pepsi", "098", 2.5, "Soft drinks", "Drinks without alcohol", "Drinks");
		articles[98] = new Article("Sprite", "099", 2.5, "Soft drinks", "Drinks without alcohol", "Drinks");
		articles[99] = new Article("Orange juice", "100", 3.5, "Juices", "Drinks without alcohol", "Drinks");
		return articles;
	}

}