package com.example.chainOfResponsibility.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
public class BatchResponse {

	@Builder.Default
	private List<BatchError> errors = new ArrayList<>();

	@Builder.Default
	private List<Success> success = new ArrayList<>();

	@Data

	public static class BatchError {

		private final String document;

		private List<FieldError> fieldErrors = new ArrayList<>();

	}

	@Data
	public static class FieldError implements Serializable {

		private static final long serialVersionUID = 1L;

		private final String field;

		private final String message;

	}

	@Data
	public class Success {

		public String document;

		public String message;

	}
}