package project3;

public enum Formation {
	A(8,3),B(8,4),C(8,5),D(8,6),E(8,7),F(7,3),G(6,4),H(5,5),I(9,3),J(10,4),K(11,5);
	
	int x;
	int y;
	Formation(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}