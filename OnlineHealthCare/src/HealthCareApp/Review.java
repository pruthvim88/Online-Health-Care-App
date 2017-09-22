package HealthCareApp;

//@Invariant({“this.p !=null && this.rating !=null && this.rating > 0"})
public class Review {
	public Review(Patient p2, int i) {
		this.p = p2;
		this.rating = i;
	}
	protected Patient p;
	protected int rating;
}
