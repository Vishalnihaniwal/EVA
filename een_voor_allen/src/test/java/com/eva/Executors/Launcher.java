package com.eva.Executors;

import java.io.IOException;

import com.eva.UI.EVA_UI;
import com.eva.Utils.UtilityFunctionBank;

import problems.evaException;

public class Launcher {
	public static void main(String[] args) throws IOException, InterruptedException, evaException {
		
		EVA_UI ui= new EVA_UI();
		ui.progressBar();
	}

}
