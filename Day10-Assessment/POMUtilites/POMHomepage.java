package POMUtilites;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Homepage {	

		WebDriver driver;
		
		public Homepage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver , this);
		}
		
		@FindBy(xpath="//span[text()='Products']")
		private WebElement product;
		
		@FindBy(id="add-to-cart-sauce-labs-backpack")
		private WebElement addtocart;
		
		@FindBy(className="shopping_cart_badge")
		private WebElement quantity;
		
		@FindBy(xpath="//a[@class='shopping_cart_link']")
		private WebElement cart;
		
		

		public String getProduct() {
			return product.getText();
		}

		public void getAddtocart() {
			addtocart.click();
		}
		
		public String getquantity() {
			return quantity.getText();
		}

		public void getCart() {
			cart.click();
		}
	}

