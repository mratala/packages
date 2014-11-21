package wMUsers;

// -----( B2B Java Code Template v1.2
// -----( CREATED: Thu Sep 05 16:40:07 CDT 2002
// -----( ON-HOST: opheim.nt.il.nbgfn.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<B2B-START-IMPORTS>> ---
// --- <<B2B-END-IMPORTS>> ---

public final class system
{
	// ---( internal utility methods )---

	final static system _instance = new system();

	static system _newInstance() { return new system(); }

	static system _cast(Object o) { return (system)o; }

	// ---( server methods )---




	public static final void debugToConsole (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(debugToConsole)>> ---
		// @sigtype java 3.5
		// [i] field:0:required message
		// This service writes a message to the Integration Server console.  The server must have been started
		// via command-line execution to use this service.
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	message = IDataUtil.getString( pipelineCursor, "message" );
		pipelineCursor.destroy();
		
		System.out.println(message); 
		// --- <<B2B-END>> ---

                
	}
}

