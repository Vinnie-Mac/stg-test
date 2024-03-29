package com.stgtest.framework.components;

/**
 * {@link StatusCode} enum used to house all HTTP status code values to be used within assertions throughout testing operations 
 * 
 * @author Vinnie-Mac
 */
public enum StatusCode {
	
	/* Full list of codes for expandability of this framework - You may assert any many variations of status code */
	CONTINUE(100, "100"),
	SWITCHING_PROTOCOLS(101, "101"),
	PROCESSING(102, "102"),
	CHECKPOINT(103, "103"),
	REQUEST_URI_TOO_LONG_122(122, "122"),
	OK(200, "200"),
	CREATED(201, "201"),
	ACCEPTED(202, "202"),
	NON_AUTHORITATIVE_INFORMATION(203, "203"),
	NO_CONTENT(204, "204"),
	RESET_CONTENT(205, "205"),
	PARTIAL_CONTENT(206, "206"),
	MULTI_STATUS(207, "207"),
	ALREADY_REPORTED(208, "208"),
	IM_USED(226, "226"),
	MULTIPLE_CHOICES(300, "300"),
	MOVED_PERMANENTLY(301, "301"),
	FOUND(302, "302"),
	SEE_OTHER(303, "303"),
	NOT_MODIFIED(304, "304"),
	USE_PROXY(305, "305"),
	TEMPORARY_REDIRECT(307, "307"),
	PERMANENT_REDIRECT(308, "308"),
	BAD_REQUEST(400, "400"),
	UNAUTHORIZED(401, "401"),
	PAYMENT_REQUIRED(402, "402"),
	FORBIDDEN(403, "403"),
	NOT_FOUND(404, "404"),
	METHOD_NOT_ALLOWED(405, "405"),
	NOT_ACCEPTABLE(406, "406"),
	PROXY_AUTHENTICATION_REQUIRED(407, "407"),
	REQUEST_TIMEOUT(408, "408"),
	CONFLICT(409, "409"),
	GONE(410, "410"),
	LENGTH_REQUIRED(411, "411"),
	PRECONDITON_FAILED(412, "412"),
	REQUEST_ENTITY_TOO_LARGE(413, "413"),
	REQUEST_URI_TOO_LONG_414(414, "414"),
	UNSUPPORTED_MEDIA_TYPE(415, "415"),
	REQUESTED_RANGE_NOT_SATISFIABLE(416, "416"),
	EXPECTATION_FAILED(417, "417"),
	UNPROCESSABLE_ENTITY(422, "422"),
	LOCKED(423, "423"),
	FAILED_DEPENDENCY(424, "424"),
	UPGRADE_REQUIRED(426, "426"),
	PRECONDITION_REQUIRED(428, "428"),
	TOO_MANY_REQUESTS(429, "429"),
	REQUEST_HEADER_FIELDS_TOO_LARGE(431, "431"),
	NO_RESPONSE(444, "444"),
	RETRY_WITH(449, "449"),
	BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS(450, "450"),
	UNAVAILABLE_FOR_LEGAL_REASONS(451, "451"),
	CLIENT_CLOSED_REQUEST(499, "499"),
	INTERNAL_SERVER_ERROR(500, "500"),
	NOT_IMPLEMENTED(501, "501"),
	BAD_GATEWAY(502, "502"),
	SERVICE_UNAVAILABLE(503, "503"),
	GATEWAY_TIMEOUT(504, "504"),
	HTTP_VERSION_NOT_SUPPORTED(505, "505"),
	VARIANT_ALSO_NEGOTIATES(506, "506"),
	INSUFFICIENT_STORAGE(507, "507"),
	LOOP_DETECTED(508, "508"),
	BANDWIDTH_LIMIT_EXCEEDED(509, "509"),
	NOT_EXTENDED(510, "510"),
	NETWORK_AUTHENTICATION_REQUIRED(511, "511"),
	NETWORK_READ_TIMEOUT_ERROR(598, "598"),
	NETWORK_CONNECT_TIMEOUT_ERROR(599, "599");


	Integer codeValue;
	String codeValueAsString;


	/**
	 * Basic constructor 
	 * 
	 * @param {@link Integer} value of HTTP status code
	 * @param {@link String} value of HTTP status code
	 */
	StatusCode(final Integer codeValue, final String codeValueAsString)
	{
		this.codeValue = codeValue;
		this.codeValueAsString = codeValueAsString;
	}


	/**
	 * Get the Integer value of status code being retrieved 
	 * 
	 * @return {@link Integer} integer value of the HTTP status code
	 */
	public Integer getValue()
	{
		return this.codeValue;
	}


	/**
	 * Get the String value of status code being retrieved
	 * 
	 * @return {@link String} string value of the HTTP status code
	 */
	public String getValueAsString()
	{
		return this.codeValueAsString;
	}
}
