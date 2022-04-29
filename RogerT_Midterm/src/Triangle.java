class Triangle {

	private double height;
	private double base;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getArea() {
		return 0.5 * base * height;
	}

	public Triangle() {
		base = 0.0;
		height = 0.0;

	}

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;

	}

}
