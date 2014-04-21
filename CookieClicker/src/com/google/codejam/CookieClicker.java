package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CookieClicker {

	public static void main(String[] args) {
		try {

			// File for input and output
			BufferedReader br = new BufferedReader(new FileReader(
					"B-large.in"));
			FileWriter fstream = new FileWriter("B-large.out");
			BufferedWriter out = new BufferedWriter(fstream);

			int testcasenum = Integer.parseInt(br.readLine());
			for (int i = 0; i < testcasenum; i++) {

				Double totalTime = 0.0;
				Double[] val = new Double[3];
				Double c, f, x;
				Double rate;
				String result;

				String[] str = br.readLine().split(" ");

				for (int j = 0; j < 3; j++)
					val[j] = new Double(str[j]).doubleValue();

				c = val[0];
				f = val[1];
				x = val[2];

				rate = 2.0;

				if (x <= c)
					totalTime = x / rate;
				else {
					for (;;) {
						if ((x / rate) < ((c / rate) + (x / (rate + f)))) {
							totalTime += x / rate;
							break;
						} else {
							totalTime += c / rate;
							rate = rate + f;
						}
					}
				}

				String s = String.format("%.7f", totalTime);
				totalTime = Double.parseDouble(s);
				result = new DecimalFormat("#0.0000000").format(totalTime);

				// System.out.println("Case #" + (i + 1) + ": " + result +
				// "\n");
				out.write("Case #" + (i + 1) + ": " + result + "\n");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
