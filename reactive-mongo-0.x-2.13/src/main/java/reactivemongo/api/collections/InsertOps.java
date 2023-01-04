package reactivemongo.api.collections;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import reactivemongo.api.commands.MultiBulkWriteResult;
import reactivemongo.api.commands.WriteResult;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.collection.Iterable;

@Weave(type=MatchType.Interface)
public abstract class InsertOps {
	
	@Weave(type=MatchType.Interface)
	public static class InsertBuilder<P> {

		@Trace
		public <T> Future<WriteResult> one(T document, final ExecutionContext ec, final Object writer) {
			String method = "one";
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Insert",method);
			return Weaver.callOriginal();
		}
		
		@Trace
		public <T> Future<MultiBulkWriteResult> many(Iterable<T> documents, ExecutionContext ec, Object writer)  {
			String method = "many";
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Insert",method);
			return Weaver.callOriginal();
		}
	}


}
