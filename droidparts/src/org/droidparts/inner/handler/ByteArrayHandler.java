/**
 * Copyright 2013 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.inner.handler;

import org.droidparts.inner.TypeHelper;
import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

public class ByteArrayHandler extends TypeHandler<byte[]> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isByteArray(cls);
	}

	@Override
	public String getDBColumnType() {
		return BLOB;
	}

	@Override
	public <V> byte[] readFromJSON(Class<byte[]> valType,
			Class<V> arrCollItemType, JSONObject obj, String key) {
		throw new IllegalArgumentException();
	}

	@Override
	protected <V> byte[] parseFromString(Class<byte[]> valType,
			Class<V> arrCollItemType, String str) {
		throw new IllegalArgumentException();
	}

	@Override
	public <V> void putToContentValues(Class<byte[]> valueType,
			Class<V> arrCollItemType, ContentValues cv, String key, byte[] val) {
		cv.put(key, val);
	}

	@Override
	public <V> byte[] readFromCursor(Class<byte[]> valType,
			Class<V> arrCollItemType, Cursor cursor, int columnIndex) {
		return cursor.getBlob(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<byte[]> valType, String[] arr) {
		throw new UnsupportedOperationException();
	}

}