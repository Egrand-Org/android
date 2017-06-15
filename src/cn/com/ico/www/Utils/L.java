package cn.com.ico.www.Utils;

import android.util.Log;

/*
 *
 * 调试日志输出类
 * 20140814
 * 
 * 
 */
public class L {
	/* 测试的时候设置成true, 发布时必须设置成false     */
	private final static boolean DEBUG=true;
	public static void Show(int logLevel,String info){
		String[] infos=getAutoJumpLogInfos();
		if(DEBUG){
			switch(logLevel){
			case 1:
				Log.v(infos[0],info+"======"+infos[1]+infos[2]);
				break;
			case 2:
				Log.d(infos[0],info+"======"+infos[1]+infos[2]);
				break;
			case 3:
				Log.i(infos[0],info+"======"+infos[1]+infos[2]);
				break;
			case 4:
				Log.w(infos[0],info+"======"+infos[1]+infos[2]);
				break;
			case 5:
				Log.e(infos[0],info+"======"+infos[1]+infos[2]);
				break;				
			}
		}
	}
	/**** 获取信息 **/
	
	private static String[] getAutoJumpLogInfos() {
		// TODO Auto-generated method stub
		String[] infos=new String[]{"","",""};
		StackTraceElement[] elements=Thread.currentThread().getStackTrace();
		if(elements.length<5){
			Log.e("Until.L", "Stack is too shallow!!![堆栈溢出]");
			return infos;
		}
		else
		{	
			infos[0] = elements[4].getClassName().substring(
					elements[4].getClassName().lastIndexOf(".") + 1);
			infos[1] = elements[4].getMethodName() + "()";
			infos[2] = " 在 (" + elements[4].getClassName() + ".java:"
					+ elements[4].getLineNumber() + ")";
			return infos;
		}
	}
}
