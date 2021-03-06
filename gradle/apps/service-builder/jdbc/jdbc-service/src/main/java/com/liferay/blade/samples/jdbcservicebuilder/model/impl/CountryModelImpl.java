/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.samples.jdbcservicebuilder.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.blade.samples.jdbcservicebuilder.model.Country;
import com.liferay.blade.samples.jdbcservicebuilder.model.CountryModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Country service. Represents a row in the &quot;country&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CountryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CountryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryImpl
 * @generated
 */
@ProviderType
public class CountryModelImpl
	extends BaseModelImpl<Country> implements CountryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a country model instance should use the <code>Country</code> interface instead.
	 */
	public static final String TABLE_NAME = "country";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table country (id LONG not null primary key,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table country";

	public static final String ORDER_BY_JPQL =
		" ORDER BY country.countryId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY country.id ASC";

	public static final String DATA_SOURCE = "extDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.blade.samples.jdbcservicebuilder.service.util.ServiceProps.
			get(
				"value.object.entity.cache.enabled.com.liferay.blade.samples.jdbcservicebuilder.model.Country"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.blade.samples.jdbcservicebuilder.service.util.ServiceProps.
			get(
				"value.object.finder.cache.enabled.com.liferay.blade.samples.jdbcservicebuilder.model.Country"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.blade.samples.jdbcservicebuilder.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.blade.samples.jdbcservicebuilder.model.Country"));

	public CountryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _countryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCountryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _countryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Country.class;
	}

	@Override
	public String getModelClassName() {
		return Country.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Country)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Country, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Country, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Country)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Country, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Country, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Country, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Country, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Country, Object>>();
		Map<String, BiConsumer<Country, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Country, ?>>();

		attributeGetterFunctions.put(
			"countryId",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getCountryId();
				}

			});
		attributeSetterBiConsumers.put(
			"countryId",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object countryId) {
					country.setCountryId((Long)countryId);
				}

			});
		attributeGetterFunctions.put(
			"countryName",
			new Function<Country, Object>() {

				@Override
				public Object apply(Country country) {
					return country.getCountryName();
				}

			});
		attributeSetterBiConsumers.put(
			"countryName",
			new BiConsumer<Country, Object>() {

				@Override
				public void accept(Country country, Object countryName) {
					country.setCountryName((String)countryName);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	@Override
	public String getCountryName() {
		if (_countryName == null) {
			return "";
		}
		else {
			return _countryName;
		}
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Country.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Country toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Country)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CountryImpl countryImpl = new CountryImpl();

		countryImpl.setCountryId(getCountryId());
		countryImpl.setCountryName(getCountryName());

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public int compareTo(Country country) {
		long primaryKey = country.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Country)) {
			return false;
		}

		Country country = (Country)obj;

		long primaryKey = country.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Country> toCacheModel() {
		CountryCacheModel countryCacheModel = new CountryCacheModel();

		countryCacheModel.countryId = getCountryId();

		countryCacheModel.countryName = getCountryName();

		String countryName = countryCacheModel.countryName;

		if ((countryName != null) && (countryName.length() == 0)) {
			countryCacheModel.countryName = null;
		}

		return countryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Country)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Country)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Country.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Country.class, ModelWrapper.class
	};

	private long _countryId;
	private String _countryName;
	private Country _escapedModel;

}