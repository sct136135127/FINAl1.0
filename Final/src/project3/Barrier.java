package project3;


import javafx.scene.image.ImageView;

public class Barrier extends ObjPlace{

	Barrier(int x,int y){
		this.x = x;
		this.y = y;
		barrierjudge = true;
		name = "z";
		image = new ImageView(project3.Main.Constant.xiaoshan);
		image.setTranslateX(x*70);
		image.setTranslateY(30+y*70);
		image.setFitHeight(70);
		image.setFitWidth(70);
		application.Main.root.getChildren().add(image);
	}
}
