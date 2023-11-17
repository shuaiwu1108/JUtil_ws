package net.shuaiwu.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;
import net.shuaiwu.netty.pojo.UnixTime;

/**
 * 时间解码器
 *
 * @author shuaiwu
 * @date 2023-11-17 17:18
 */
public class TimeDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(
        ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
