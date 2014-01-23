package org.wisdom.akka;

import java.io.InputStream;
import java.util.concurrent.Callable;

import org.wisdom.api.http.Context;
import org.wisdom.api.http.Result;

import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import akka.actor.ActorSystem;

/**
 * A service to access the wisdom actor system and ease the dispatching of task.
 */
public interface AkkaSystemService {
    /**
     * @return the Wisdom actor system.
     */
    ActorSystem system();

    /**
     * Dispatches the given task using an execution context preserving the given HTTP Context and the thread context
     * classloader.
     * @param callable the classloader
     * @param context the context
     * @return the future
     */
    Future<Result> dispatchResultWithContext(Callable<Result> callable, Context context);

    /**
     * Dispatches the given task using an execution context preserving the current HTTP Context and the thread context
     * classloader.
     * @param callable the classloader
     * @return the future
     */
    Future<Result> dispatchResult(Callable<Result> callable);
    
    Future<InputStream> dispatchInputStream(Callable<InputStream> callable);

    /**
     * Gets an Akka execution context preserving the HTTP Context and thread context classloader of the caller thread.
     * @return the execution context.
     */
    public ExecutionContext fromThread();
}
