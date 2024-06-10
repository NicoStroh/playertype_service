package de.unistuttgart.iste.meitrex.playertype_service.exception;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Resolves exceptions thrown during data fetching.
 * Converts exceptions to {@link GraphQLError}s and logs them.
 */
@Component
@Slf4j
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {



}