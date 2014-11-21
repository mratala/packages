package wMUsers;

// -----( B2B Java Code Template v1.2
// -----( CREATED: Thu Sep 05 14:29:37 CDT 2002
// -----( ON-HOST: opheim.nt.il.nbgfn.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<B2B-START-IMPORTS>> ---
import com.wm.app.b2b.server.ServerAPI;
import java.io.*;
// --- <<B2B-END-IMPORTS>> ---

public final class packages
{
	// ---( internal utility methods )---

	final static packages _instance = new packages();

	static packages _newInstance() { return new packages(); }

	static packages _cast(Object o) { return (packages)o; }

	// ---( server methods )---




	public static final void getEnabledPackages (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(getEnabledPackages)>> ---
		// @sigtype java 3.5
		// [o] field:1:required deleteable
		
		ServerAPI sapi = new ServerAPI();
		String [] deleteable = sapi.getEnabledPackages();
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "deleteable", deleteable );
		pipelineCursor.destroy();
		
		// --- <<B2B-END>> ---

                
	}



	public static final void moveZIPFilesToDirectory (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(moveZIPFilesToDirectory)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		
		ServerAPI sapi = new ServerAPI();
		File[] allZips = null;
		File tmp = null;
		File destFile = null;
		boolean isSuccess = false;
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	date = IDataUtil.getString( pipelineCursor, "date" );
		pipelineCursor.destroy();
		
		// Get the server config directory
		File f = sapi.getServerConfigDir();
		
		// Get the parent directory of the config directory.  This is the package home directory.
		File p = new File(f.getParent());
		 
		// Create a File object for the replicate/outbound directory
		String path = f.separator + "replicate" + f.separator + "outbound" + f.separator;
		File sourceDir = new File(p + path);
		File targetDir = new File(p + path + date + f.separator);
		
		// Create a backup directory for today's date and move all ZIP files to it from the replicate/outbound directory
		if (targetDir.mkdir()) {
			allZips = sourceDir.listFiles();
			for (int i = 0; i < allZips.length; i++) {
				if (allZips[i].isFile()) {
					tmp = new File (sourceDir, allZips[i].getName());
					destFile = new File (p + path + date + f.separator + allZips[i].getName());
					if (!tmp.renameTo(destFile)) {
						System.out.println("The ZIP file " + allZips[i].toString() + " could not be moved to " + destFile.toString());
					} 
				}
			}
		}
				
		
		
		// --- <<B2B-END>> ---

                
	}

	// --- <<B2B-START-SHARED>> ---
 
	// --- <<B2B-END-SHARED>> ---
}

