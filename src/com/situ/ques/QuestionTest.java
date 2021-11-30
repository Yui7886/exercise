package com.situ.ques;
// (业务)功能类

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionTest {
	public static void main(String[] args) {
		QuestionTest model = new QuestionTest();
		model.start();
	}

	public void start() {
		while (true) {// 业务逻辑
			System.out.println("-------------------------------");
			System.out.println("------请选择功能：(1-9)-----------");
			System.out.println("------1-试题录入(题号不能重复)------");
			System.out.println("------2-试题查询(按照题号查看)------");
			System.out.println("------3-试题删除(按照题号删除)------");
			System.out.println("------4-试题修改(按照题号修改)------");
			System.out.println("------5-查看试题(查看全部试题)------");
			System.out.println("------6-试题排序(根据题号排序)------");
			System.out.println("------7-试题排序(根据分值排序)------");
			System.out.println("------8-回答试题(正确数，得分)------");
			System.out.println("------9-退出--------------------");
			System.out.print("请输入功能序号：");
			switch (Integer.parseInt(scanner.nextLine())) {
			case 1:
				inputs();
				break;
			case 2:
				getModelById();
				break;
			case 3:
				delModelById();
				break;
			case 4:
				updModelById();
				break;
			case 5:
				print();
				break;
			case 6:
				sortById();
				break;
			case 7:
				sortByValue();
				break;
			case 8:
				test();
				break;
			case 9:
				System.out.println("*******已退出！*******");
				return;
			}
			System.out.println("*******是否退出系统？y/n********");
			if ("y".equalsIgnoreCase(scanner.nextLine())) {
				System.out.println("*******已退出！*******");
				break;
			}
		}
	}

	// 8-作答
	public void test() {
		int sum = 0;// 总分
		int count = 0;// 正确题目数
		for (QuestionModel model : list) {
			System.out.println("题号:" + model.getId());
			System.out.println("题目:" + model.getTitle());
			System.out.println("选项A:" + model.getOptionA());
			System.out.println("选项B:" + model.getOptionB());
			System.out.println("选项C:" + model.getOptionC());
			System.out.println("选项D:" + model.getOptionD());
			System.out.println("分值：" + model.getValue());
			System.out.print("请输入答案：");
			String line = scanner.nextLine();
			if (model.getAnswer().equalsIgnoreCase(line)) {
				sum += model.getValue();
				count++;
			}
		}
		System.out.println("正确题目数:" + count + ",总分为：" + sum);

	}

	// 7-排序(根据分值排序)
	public void sortByValue() {
		int len = list.size();
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				QuestionModel m1 = list.get(j);
				QuestionModel m2 = list.get(j + 1);
				if (m1.getValue() > m2.getValue()) {
					list.set(j, m2);
					list.set(j + 1, m1);
				}
			}
		}
		System.out.println("------已按分值排序完成！------");
	}

	// 6-排序(根据题号排序)
	public void sortById() {
		int len = list.size();
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				QuestionModel m1 = list.get(j);
				QuestionModel m2 = list.get(j + 1);
				if (m1.getId() > m2.getId()) {
					list.set(j, m2);
					list.set(j + 1, m1);
				}
			}
		}
		System.out.println("------已按题号排序完成！------");
	}
	
	// 5-打印全部试题
	public void print() {
		System.out.println("===============================");
		for (QuestionModel model : list) {
			System.out.println("题号:" + model.getId());
			System.out.println("题目:" + model.getTitle());
			System.out.println("选项A:" + model.getOptionA());
			System.out.println("选项B:" + model.getOptionB());
			System.out.println("选项C:" + model.getOptionC());
			System.out.println("选项D:" + model.getOptionD());
			System.out.println("答案:" + model.getAnswer());
			System.out.println("分值:" + model.getValue());
			System.out.println("=====================================");
		}
		System.out.println("------全部试题打印完成！------");
	}
	
	// 4-试题修改（按题号）
	public void updModelById() {
		System.out.print("请输入即将修改的题号：");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.println("题号:" + model.getId());
				System.out.println("题目:" + model.getTitle());
				System.out.println("选项A:" + model.getOptionA());
				System.out.println("选项B:" + model.getOptionB());
				System.out.println("选项C:" + model.getOptionC());
				System.out.println("选项D:" + model.getOptionD());
				System.out.println("答案:" + model.getAnswer());
				System.out.println("分值:" + model.getValue());
				System.out.println("请进行修改操作：");
				System.out.print("请输入题目：");
				model.setTitle(scanner.nextLine());
				System.out.print("请输入选项A：");
				model.setOptionA(scanner.nextLine());
				System.out.print("请输入选项B：");
				model.setOptionB(scanner.nextLine());
				System.out.print("请输入选项C：");
				model.setOptionC(scanner.nextLine());
				System.out.print("请输入选项D：");
				model.setOptionD(scanner.nextLine());
				System.out.print("请输入答案：");
				model.setAnswer(scanner.nextLine());
				System.out.print("请输入分值：");
				model.setValue(Integer.parseInt(scanner.nextLine()));
			}
		System.out.println("--------修改完毕！--------");
	}

	// 3-删除试题（按题号）
	public void delModelById() {
		System.out.print("请输入即将删除的题号：");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				list.remove(id - 1);
				System.out.println("该题目（" + id + "）已删除");
				return;
			}
		System.out.println("该题目（" + id + "）不存在");
	}

	// 2-查询题目（按题号）
	public void getModelById() {
		System.out.print("请输入即将查询的题号：");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.println("题号:" + model.getId());
				System.out.println("题目:" + model.getTitle());
				System.out.println("选项A:" + model.getOptionA());
				System.out.println("选项B:" + model.getOptionB());
				System.out.println("选项C:" + model.getOptionC());
				System.out.println("选项D:" + model.getOptionD());
				System.out.println("答案:" + model.getAnswer());
				System.out.println("分值:" + model.getValue());
			}
	}

	// 1-试题录入
	public void inputs() {
		while (true) {
			input();
			System.out.println("录入完成，是否继续录入？y/n：");
			if ("n".equalsIgnoreCase(scanner.nextLine())) {
				break;
			}
		}
	}

	/**
	 * 
	 * @param id 题号
	 * @return 判断题号是否重复
	 */
	public boolean isExist(int id) {
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.print("该题号（" + id + "）已存在，请重新输入：");
				return true;
			}
		return false;
	}

	ArrayList<QuestionModel> list = new ArrayList<>();

	public void input() {
		QuestionModel model = new QuestionModel();
		System.out.print("请输入题号：");
		int id = 0;
		do {
			id = Integer.parseInt(scanner.nextLine());
		} while (isExist(id));
		model.setId(id);
		System.out.print("请输入题目：");
		model.setTitle(scanner.nextLine());
		System.out.print("请输入选项A：");
		model.setOptionA(scanner.nextLine());
		System.out.print("请输入选项B：");
		model.setOptionB(scanner.nextLine());
		System.out.print("请输入选项C：");
		model.setOptionC(scanner.nextLine());
		System.out.print("请输入选项D：");
		model.setOptionD(scanner.nextLine());
		System.out.print("请输入答案：");
		model.setAnswer(scanner.nextLine());
		System.out.print("请输入分值：");
		model.setValue(Integer.parseInt(scanner.nextLine()));
		list.add(model);
	}


	static Scanner scanner = new Scanner(System.in);
}
