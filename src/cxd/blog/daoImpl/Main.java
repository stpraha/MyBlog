package cxd.blog.daoImpl;

import java.util.List;

import cxd.blog.dao.ArticleDao;
import cxd.blog.dao.UserDao;
import cxd.blog.model.Article;
import cxd.blog.model.User;

public class Main {
	public static void main(String[] args) {
		ArticleDao adi = ArticleDaoImpl.getInstance();
		UserDao ud = UserDaoImpl.getInstance();
		User user = new User(21, "stpraha", "cxd123", "chenxd");
		String text = "# SSD_Light \\n Reference \\n --------- \\n I refered `balancap's SSD` code. But his code is too heavy for me to understand. So I decided to write my own SSD code.<br> \\n My code is strongly similar to his.<br> \\n  \\n Envs \\n ---- \\n * `Python 3.6.8` <br> \\n * `tensorflow-gpu 1.4.0`<br> \\n * `tensorflow-tensorboard 0.4.0`<br> \\n * `CUDA Version 8.0.61`<br> \\n * `CUDNN Version 6.0.21`<br> \\n  \\n Test \\n ---- \\n The test function is not well finished.<br> \\n `python run.py --test --image_path /TEST_IMAGE_PATH`<br> \\n `--model_path /YOU_MODEL_PATH --out_path /OUT_RESULT_PATH` and batch_size are also changeable<br> \\n Look run.py and test_ssd.py for details.<br> \\n  \\n Train \\n ----- \\n `python run.py --train --image_path /TRAIN_IMAGE_PATH --annotation_path /TRAIN_ANNOTATION_PATH`<br> \\n `--restore` is an optional that you can continue previous training.<br> \\n batch_size, model_path, learning_rate, epochs are also caon be changed.<br> \\n Look run.py and train_ssd.py for details<br> \\n Your own data must be `VOC2007 like`. To change FDDB dataset to VOC like, you can see [my other project](https://github.com/stpraha/FDDB2VOClike). \\n  \\n Example \\n ------- \\n ![pic1](https://github.com/stpraha/SSD_Light/blob/master/examples/0000.jpg) \\n ![pic2](https://github.com/stpraha/SSD_Light/blob/master/examples/0001.jpg) \\n  \\n  \\n Progress \\n -------- \\n Under development<br> \\n This project is almost finished at 2019/3/22.<br> \\n  \\n 2019/3/5<br> \\n Fixed a bug: Attempting to use uninitialized value<br> \\n Refactored loss_function, ssd_net and train_ssd<br> \\n  \\n 2019/3/6<br> \\n Fixed a bug: with training loop goes on, the speed decreases.<br> \\n Rewrite ground_truth_process.py. It was changed from using Tensorflow to using Numpy.<br> \\n  \\n 2019/3/9<br> \\n Fixed a bug: dropout layer still working when testing.<br> \\n Rewrite loss_function.py. Rewrite the SmoothL1-Loss function.<br> \\n Add test_ssd.py.<br> \\n Add nms: encode_predictions.py.<br> \\n Add picture saver: draw_pic.py.<br> \\n  \\n 2019/3/16<br> \\n Fixed a bug: the loss doesn's decrease.<br> \\n Found a bug in balancap's code. Submitted an Issue.<br> \\n Build a new path.<br> \\n Single class location and classification is abled.<br> \\n  \\n 2019/3/22<br> \\n A runnable version is published.<br> \\n run.py was added.<br> \\n Some functions wer rewrited.<br> \\n Try to adjust parameters, but it doesnt work well.<br> \\n  \\n Next task:<br> \\n Train, test, adjust parameters<br> \\n Then write a better picture saver.<br> \\n Write a config.conf \\n  \\n  \\n Sadness \\n ------- \\n Due to my fault. Old commit log was missiing. \\n ";
		Article article = new Article(15, "SSD_Light ReadMe", "Strpaha", "哪有什么分类", "2019-04-04 22:45:58", 1, 2, 3, text);
		adi.addArticle(article);
		
//		ud.register("stprahb", "cxd123", "chenxdd");
//		User user = ud.login("stpraha", "cxd123");
//		
//		System.out.println(System.getProperty("java.class.path"));
//		
//		if(user == null) System.out.println("Login failed!");
//		else {
//			System.out.println(user.getNickName());
//			System.out.println(user.getUserId());
//			System.out.println(user.getUsername());
//			System.out.println(user.getPassword());
//		}
	}
}
