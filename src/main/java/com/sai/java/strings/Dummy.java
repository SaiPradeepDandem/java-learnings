package com.sai.java.strings;

public class Dummy {

	public static void main(String[] args) {
		
		int[] med_intoll_patientId = { 1, 58, 60, 65, 75, 78, 116, 117, 118, 120, 126, 127, 129, 130, 131, 132, 133};
		// 60,75,117,118,120,127,129,130,132,133
		
		int[] comorbidity_patientId = {1, 2,38,58,60, 64, 66, 78, 79, 91, 117, 118,	119, 120, 121, 126, 129, 130, 131, 132 };
		
		String[] cnkcodes = {"0032771","0032896","0043737","0051714","0073924"};
		int[] filteredPat = {60};//{60,75,117,118,120,127,129,130,132,133}
		
		
		for (String cnkCode : cnkcodes) {
			System.out.println("");
			System.out.println("-----------------------------------\n CNK CODE ::::: "+cnkCode+"\n");
			//System.out.println("COMORBIDITY\n");
			for (int patientId : filteredPat) {
				String s ="SELECT APB_FB.SpecialityName, APB_FBW.ContraindicationCode, APB_WB.DescriptionDutch, APB_WB.DescriptionFrench"+ 
						  " FROM APB_FB, APB_FBW, APB_WBSELECT, APB_WB,"+ 
						  " Contraindication_IntolleranceWBGroup as CIWB, Medical_CoMorbidity as MCM"+
						  " WHERE APB_FB.NationalCode = "+cnkCode+" AND"+
						  " APB_FB.Language LIKE 'B' AND"+
						  " APB_FB.ReferenceNb = APB_FBW.ReferenceNb AND"+
						  " APB_FBW.ContraindicationCode =  APB_WB.ContraindicationCode AND"+
						  " APB_FBW.ContraindicationCode =  APB_WBSELECT.CodeContraindication AND"+
						  " APB_WBSELECT.CodeContraindicationGroup = CIWB.WBGROUP AND"+
						  " CIWB.ci_id = MCM.ci_id AND"+
						  " MCM.patient_id = '"+patientId+"' ";
						  //" AND MCM.outdatedDate = null ;"	;
				System.out.println(""+s);
			}
			//System.out.println("\n");
			//System.out.println("MEDICAL INTOLLERANCE\n");
			for (int patientId : filteredPat) {
				String s ="SELECT APB_FB.SpecialityName, APB_FBW.ContraindicationCode, APB_WB.DescriptionDutch, APB_WB.DescriptionFrench"+ 
						  " FROM APB_FB, APB_FBW, APB_WBSELECT, APB_WB,"+ 
						  " Contraindication_IntolleranceWBGroup as CIWB, Medical_MedicalIntolerance as MMI"+
						  " WHERE APB_FB.NationalCode = "+cnkCode+" AND"+
						  " APB_FB.Language LIKE 'B' AND"+
						  " APB_FB.ReferenceNb = APB_FBW.ReferenceNb AND"+
						  " APB_FBW.ContraindicationCode =  APB_WB.ContraindicationCode AND"+
						  " APB_FBW.ContraindicationCode =  APB_WBSELECT.CodeContraindication AND"+
						  " APB_WBSELECT.CodeContraindicationGroup = CIWB.WBGROUP AND"+
						  " CIWB.ci_id = MMI.ci_id AND"+
						  " MMI.patient_id = '"+patientId+"' " ;
						 // " MMI.outdatedDate = null;"	;
				System.out.println(""+s);
			}
		}
		
		/*for (int patientId : med_intoll_patientId) {
			String s ="SELECT APB_FB.SpecialityName, APB_FBW.ContraindicationCode, APB_WB.DescriptionDutch, APB_WB.DescriptionFrench,APB_FB.NationalCode"+ 
					  " FROM APB_FB, APB_FBW, APB_WBSELECT, APB_WB,"+ 
					  " Contraindication_IntolleranceWBGroup as CIWB, Medical_MedicalIntolerance as MMI"+
					  " WHERE APB_FB.Language LIKE 'B' AND"+
					  " APB_FB.ReferenceNb = APB_FBW.ReferenceNb AND"+
					  " APB_FBW.ContraindicationCode =  APB_WB.ContraindicationCode AND"+
					  " APB_FBW.ContraindicationCode =  APB_WBSELECT.CodeContraindication AND"+
					  " APB_WBSELECT.CodeContraindicationGroup = CIWB.WBGROUP AND"+
					  " CIWB.ci_id = MMI.ci_id AND"+
					  " MMI.patient_id = '"+patientId+"' AND"+
					  " MMI.outdatedDate = null;"	;
			System.out.println(""+s);
		}*/
		
		/*for (int patientId : med_intoll_patientId) {
		String s = "SELECT distinct MMI.patient_id, CIWB.WBGROUP , APB_WBSELECT.CodeContraindicationGroup,APB_FBW.ContraindicationCode"+
				" FROM APB_FBW, APB_WB, APB_WBSELECT, Contraindication_IntolleranceWBGroup as CIWB,  Medical_MedicalIntolerance as MMI"+
				" WHERE MMI.patient_id = '"+patientId+"' AND "+
				" CIWB.ci_id = MMI.ci_id AND"+
				" APB_WBSELECT.CodeContraindicationGroup = CIWB.WBGROUP AND"+
				" APB_FBW.ContraindicationCode =  APB_WBSELECT.CodeContraindication ;";
		System.out.println(""+s);
		}*/
	}

}
