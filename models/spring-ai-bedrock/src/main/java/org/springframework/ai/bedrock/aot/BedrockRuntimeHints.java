/*
 * Copyright 2023 - 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.ai.bedrock.aot;

import org.springframework.ai.bedrock.anthropic.AnthropicChatOptions;
import org.springframework.ai.bedrock.anthropic.api.AnthropicChatBedrockApi;
import org.springframework.ai.bedrock.api.AbstractBedrockApi;
import org.springframework.ai.bedrock.cohere.BedrockCohereChatOptions;
import org.springframework.ai.bedrock.cohere.BedrockCohereEmbeddingOptions;
import org.springframework.ai.bedrock.cohere.api.CohereChatBedrockApi;
import org.springframework.ai.bedrock.cohere.api.CohereEmbeddingBedrockApi;
import org.springframework.ai.bedrock.jurassic2.api.Ai21Jurassic2ChatBedrockApi;
import org.springframework.ai.bedrock.llama2.BedrockLlama2ChatOptions;
import org.springframework.ai.bedrock.llama2.api.Llama2ChatBedrockApi;
import org.springframework.ai.bedrock.titan.BedrockTitanChatOptions;
import org.springframework.ai.bedrock.titan.api.TitanChatBedrockApi;
import org.springframework.ai.bedrock.titan.api.TitanEmbeddingBedrockApi;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import static org.springframework.ai.aot.AiRuntimeHints.findJsonAnnotatedClassesInPackage;

/**
 * The BedrockRuntimeHints class is responsible for registering runtime hints for Bedrock
 * AI API classes.
 *
 * @author Josh Long
 * @author Christian Tzolov
 * @author Mark Pollack
 */
public class BedrockRuntimeHints implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
		var mcs = MemberCategory.values();
		for (var tr : findJsonAnnotatedClassesInPackage(AbstractBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(Ai21Jurassic2ChatBedrockApi.class))
			hints.reflection().registerType(tr, mcs);

		for (var tr : findJsonAnnotatedClassesInPackage(CohereChatBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(BedrockCohereChatOptions.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(CohereEmbeddingBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(BedrockCohereEmbeddingOptions.class))
			hints.reflection().registerType(tr, mcs);

		for (var tr : findJsonAnnotatedClassesInPackage(Llama2ChatBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(BedrockLlama2ChatOptions.class))
			hints.reflection().registerType(tr, mcs);

		for (var tr : findJsonAnnotatedClassesInPackage(TitanChatBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(BedrockTitanChatOptions.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(TitanEmbeddingBedrockApi.class))
			hints.reflection().registerType(tr, mcs);

		for (var tr : findJsonAnnotatedClassesInPackage(AnthropicChatBedrockApi.class))
			hints.reflection().registerType(tr, mcs);
		for (var tr : findJsonAnnotatedClassesInPackage(AnthropicChatOptions.class))
			hints.reflection().registerType(tr, mcs);
	}

}
