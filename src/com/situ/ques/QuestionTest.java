package com.situ.ques;
// (ҵ��)������

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionTest {
	public static void main(String[] args) {
		QuestionTest model = new QuestionTest();
		model.start();
	}

	public void start() {
		while (true) {// ҵ���߼�
			System.out.println("-------------------------------");
			System.out.println("------��ѡ���ܣ�(1-9)-----------");
			System.out.println("------1-����¼��(��Ų����ظ�)------");
			System.out.println("------2-�����ѯ(������Ų鿴)------");
			System.out.println("------3-����ɾ��(�������ɾ��)------");
			System.out.println("------4-�����޸�(��������޸�)------");
			System.out.println("------5-�鿴����(�鿴ȫ������)------");
			System.out.println("------6-��������(�����������)------");
			System.out.println("------7-��������(���ݷ�ֵ����)------");
			System.out.println("------8-�ش�����(��ȷ�����÷�)------");
			System.out.println("------9-�˳�--------------------");
			System.out.print("�����빦����ţ�");
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
				System.out.println("*******���˳���*******");
				return;
			}
			System.out.println("*******�Ƿ��˳�ϵͳ��y/n********");
			if ("y".equalsIgnoreCase(scanner.nextLine())) {
				System.out.println("*******���˳���*******");
				break;
			}
		}
	}

	// 8-����
	public void test() {
		int sum = 0;// �ܷ�
		int count = 0;// ��ȷ��Ŀ��
		for (QuestionModel model : list) {
			System.out.println("���:" + model.getId());
			System.out.println("��Ŀ:" + model.getTitle());
			System.out.println("ѡ��A:" + model.getOptionA());
			System.out.println("ѡ��B:" + model.getOptionB());
			System.out.println("ѡ��C:" + model.getOptionC());
			System.out.println("ѡ��D:" + model.getOptionD());
			System.out.println("��ֵ��" + model.getValue());
			System.out.print("������𰸣�");
			String line = scanner.nextLine();
			if (model.getAnswer().equalsIgnoreCase(line)) {
				sum += model.getValue();
				count++;
			}
		}
		System.out.println("��ȷ��Ŀ��:" + count + ",�ܷ�Ϊ��" + sum);

	}

	// 7-����(���ݷ�ֵ����)
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
		System.out.println("------�Ѱ���ֵ������ɣ�------");
	}

	// 6-����(�����������)
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
		System.out.println("------�Ѱ����������ɣ�------");
	}
	
	// 5-��ӡȫ������
	public void print() {
		System.out.println("===============================");
		for (QuestionModel model : list) {
			System.out.println("���:" + model.getId());
			System.out.println("��Ŀ:" + model.getTitle());
			System.out.println("ѡ��A:" + model.getOptionA());
			System.out.println("ѡ��B:" + model.getOptionB());
			System.out.println("ѡ��C:" + model.getOptionC());
			System.out.println("ѡ��D:" + model.getOptionD());
			System.out.println("��:" + model.getAnswer());
			System.out.println("��ֵ:" + model.getValue());
			System.out.println("=====================================");
		}
		System.out.println("------ȫ�������ӡ��ɣ�------");
	}
	
	// 4-�����޸ģ�����ţ�
	public void updModelById() {
		System.out.print("�����뼴���޸ĵ���ţ�");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.println("���:" + model.getId());
				System.out.println("��Ŀ:" + model.getTitle());
				System.out.println("ѡ��A:" + model.getOptionA());
				System.out.println("ѡ��B:" + model.getOptionB());
				System.out.println("ѡ��C:" + model.getOptionC());
				System.out.println("ѡ��D:" + model.getOptionD());
				System.out.println("��:" + model.getAnswer());
				System.out.println("��ֵ:" + model.getValue());
				System.out.println("������޸Ĳ�����");
				System.out.print("��������Ŀ��");
				model.setTitle(scanner.nextLine());
				System.out.print("������ѡ��A��");
				model.setOptionA(scanner.nextLine());
				System.out.print("������ѡ��B��");
				model.setOptionB(scanner.nextLine());
				System.out.print("������ѡ��C��");
				model.setOptionC(scanner.nextLine());
				System.out.print("������ѡ��D��");
				model.setOptionD(scanner.nextLine());
				System.out.print("������𰸣�");
				model.setAnswer(scanner.nextLine());
				System.out.print("�������ֵ��");
				model.setValue(Integer.parseInt(scanner.nextLine()));
			}
		System.out.println("--------�޸���ϣ�--------");
	}

	// 3-ɾ�����⣨����ţ�
	public void delModelById() {
		System.out.print("�����뼴��ɾ������ţ�");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				list.remove(id - 1);
				System.out.println("����Ŀ��" + id + "����ɾ��");
				return;
			}
		System.out.println("����Ŀ��" + id + "��������");
	}

	// 2-��ѯ��Ŀ������ţ�
	public void getModelById() {
		System.out.print("�����뼴����ѯ����ţ�");
		int id = Integer.parseInt(scanner.nextLine());
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.println("���:" + model.getId());
				System.out.println("��Ŀ:" + model.getTitle());
				System.out.println("ѡ��A:" + model.getOptionA());
				System.out.println("ѡ��B:" + model.getOptionB());
				System.out.println("ѡ��C:" + model.getOptionC());
				System.out.println("ѡ��D:" + model.getOptionD());
				System.out.println("��:" + model.getAnswer());
				System.out.println("��ֵ:" + model.getValue());
			}
	}

	// 1-����¼��
	public void inputs() {
		while (true) {
			input();
			System.out.println("¼����ɣ��Ƿ����¼�룿y/n��");
			if ("n".equalsIgnoreCase(scanner.nextLine())) {
				break;
			}
		}
	}

	/**
	 * 
	 * @param id ���
	 * @return �ж�����Ƿ��ظ�
	 */
	public boolean isExist(int id) {
		for (QuestionModel model : list)
			if (model.getId() == id) {
				System.out.print("����ţ�" + id + "���Ѵ��ڣ����������룺");
				return true;
			}
		return false;
	}

	ArrayList<QuestionModel> list = new ArrayList<>();

	public void input() {
		QuestionModel model = new QuestionModel();
		System.out.print("��������ţ�");
		int id = 0;
		do {
			id = Integer.parseInt(scanner.nextLine());
		} while (isExist(id));
		model.setId(id);
		System.out.print("��������Ŀ��");
		model.setTitle(scanner.nextLine());
		System.out.print("������ѡ��A��");
		model.setOptionA(scanner.nextLine());
		System.out.print("������ѡ��B��");
		model.setOptionB(scanner.nextLine());
		System.out.print("������ѡ��C��");
		model.setOptionC(scanner.nextLine());
		System.out.print("������ѡ��D��");
		model.setOptionD(scanner.nextLine());
		System.out.print("������𰸣�");
		model.setAnswer(scanner.nextLine());
		System.out.print("�������ֵ��");
		model.setValue(Integer.parseInt(scanner.nextLine()));
		list.add(model);
	}


	static Scanner scanner = new Scanner(System.in);
}
