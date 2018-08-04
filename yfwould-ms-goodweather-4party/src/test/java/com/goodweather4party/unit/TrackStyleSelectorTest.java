package com.goodweather4party.unit;

import com.goodweather4party.domain.TrackStyles;
import com.goodweather4party.service.TrackStyleSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
public class TrackStyleSelectorTest {

    @Spy
    private TrackStyleSelector trackStyleSelector;

    @Test
    public void testSuggestOK(){
        assertThat(trackStyleSelector.selectPlaylist(31), is(equalTo(TrackStyles.SUGGEST)));
    }

    @Test
    public void testSuggestFail(){
        assertThat(trackStyleSelector.selectPlaylist(30), is(not(TrackStyles.SUGGEST)));
    }

    @Test
    public void testPop15OK(){
        assertThat(trackStyleSelector.selectPlaylist(15), is(equalTo(TrackStyles.POP)));
    }

    @Test
    public void testPop30OK(){
        assertThat(trackStyleSelector.selectPlaylist(30), is(equalTo(TrackStyles.POP)));
    }

    @Test
    public void testPop14Fail(){
        assertThat(trackStyleSelector.selectPlaylist(14), is(not(TrackStyles.POP)));
    }

    @Test
    public void testPop31Fail(){
        assertThat(trackStyleSelector.selectPlaylist(31), is(not(TrackStyles.POP)));
    }

    @Test
    public void testRock10OK(){
        assertThat(trackStyleSelector.selectPlaylist(10), is(equalTo(TrackStyles.ROCK)));
    }

    @Test
    public void testRock14OK(){
        assertThat(trackStyleSelector.selectPlaylist(14), is(equalTo(TrackStyles.ROCK)));
    }

    @Test
    public void testRock9Fail(){
        assertThat(trackStyleSelector.selectPlaylist(9), is(not(TrackStyles.ROCK)));
    }

    @Test
    public void testRock15Fail(){
        assertThat(trackStyleSelector.selectPlaylist(15), is(not(TrackStyles.ROCK)));
    }

    @Test
    public void testClassical9OK(){
        assertThat(trackStyleSelector.selectPlaylist(9), is(equalTo(TrackStyles.CLASSICAL)));
    }

    @Test
    public void testClassical0Fail(){
        assertThat(trackStyleSelector.selectPlaylist(10), is(not(TrackStyles.CLASSICAL)));
    }
}